package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailCursor;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailSelection;
import com.mapmyindia.ceinfo.silvassa.utils.DateTimeUtils;
import com.mapmyindia.ceinfo.silvassa.utils.DialogHandler;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;
import com.orhanobut.logger.Logger;

import java.util.Locale;

/**
 * Created by ceinfo on 06-03-2017.
 */

public class PaymentActivity extends BaseActivity implements DialogHandler.OnProceedDialogListener {
    private static final String TAG = PaymentActivity.class.getSimpleName();

    private String payableAmount;
    private String propId;
    private EditText mEtAmount;
    private RadioGroup rgPtop;
    private EditText mEtCheque;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_payment);

        Bundle extras = getIntent().getExtras();

        if (null != extras && extras.containsKey(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {

            propId = extras.getString(INTENT_PARAMETERS._PREFILL_PROPERTYID);

            TaxdetailSelection selection = new TaxdetailSelection();
            selection.propertyid(propId);

            TaxdetailCursor cursor = selection.query(getContentResolver());

            if (cursor.moveToFirst()) {
                payableAmount = cursor.getPayableamount();
            }
        }

        findViewByIDs();

    }

    @Override
    public void onProceedClicked() {
        paymentOffline();
    }

    @Override
    public void onActionCliked() {

    }

    @Override
    public void setmTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) findViewById(R.id.toolbar));

        setmTitle("Last Synced : " + SharedPrefeHelper.getLastSync(this));

        setSupportActionBar(getToolbar());

        mEtAmount = (EditText) findViewById(R.id.et_amount);
        mEtCheque = (EditText) findViewById(R.id.et_cheque);

        mEtAmount = ((EditText) findViewById(R.id.et_amount));

        rgPtop = (RadioGroup) findViewById(R.id.rg_ptp);

        rgPtop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_pmode_cash:
                        findViewById(R.id.linear_container_cheque).setVisibility(View.GONE);
                        break;
                    case R.id.rb_pmode_cheque:
                        findViewById(R.id.linear_container_cheque).setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_pmode_pos:
                        findViewById(R.id.linear_container_cheque).setVisibility(View.GONE);
                        break;
                    default:
                        findViewById(R.id.linear_container_cheque).setVisibility(View.GONE);
                        break;
                }
            }
        });

        mEtAmount.setText(String.format(Locale.getDefault(), "%.2f", null != payableAmount && !payableAmount.isEmpty() ? Double.parseDouble(payableAmount) : 0));

        ((RadioButton) rgPtop.findViewById(R.id.rb_pmode_cash)).setChecked(true);

        findViewById(R.id.et_payment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DialogHandler(PaymentActivity.this).showProceedDialog(PaymentActivity.this, "Proceed With Payment Of \n\r\t Rs. " + mEtAmount.getText().toString() + "");
            }
        });
    }

    private void paymentOffline() {

        boolean isValid = true;

        TaxdetailSelection selection = new TaxdetailSelection();
        selection.propertyid(propId);
        TaxdetailCursor cursor = selection.query(getContentResolver());
        RadioButton rb = (RadioButton) rgPtop.findViewById(rgPtop.getCheckedRadioButtonId());

        String propId = getIntent().getExtras().getString(INTENT_PARAMETERS._PREFILL_PROPERTYID);
        String mode = null != rb && rb.isChecked() ? rb.getText().toString() : null;
        String amount = mEtAmount.getText().toString();
        String taxNo = cursor.moveToFirst() ? cursor.getTaxno() : "";
        String userId = SharedPrefeHelper.getUserId(this);
        String cheque = !StringUtils.isNullOrEmpty(mode) && mode.equalsIgnoreCase(getString(R.string.cheque)) ? mEtCheque.getText().toString() : "";

        long timeInMillis = System.currentTimeMillis();

        String pdate = DateTimeUtils.getFormattedDatefromLong(timeInMillis);

        if (StringUtils.isNullOrEmpty(userId)) {
            isValid = false;
        }

        if (StringUtils.isNullOrEmpty(propId)) {
            isValid = false;
        }

        if (StringUtils.isNullOrEmpty(taxNo)) {
            isValid = false;
        }

        if (StringUtils.isNullOrEmpty(amount)) {
            isValid = false;
        }

        if (StringUtils.isNullOrEmpty(pdate)) {
            isValid = false;
        }

        if (StringUtils.isNullOrEmpty(mode)) {
            isValid = false;
        }

        if (!StringUtils.isNullOrEmpty(mode)
                && mode.equalsIgnoreCase(getString(R.string.cheque))
                && StringUtils.isNullOrEmpty(cheque)) {
            isValid = false;
        }

        if (isValid) {

            long id = insertPayment(userId, propId, taxNo, amount, pdate, mode, cheque);

            if (id < 0L) {

                //Todo update payment info

            } else {

                Intent intent = new Intent(this, PrintActivity.class);
                Bundle extras = new Bundle();
                extras.putString(INTENT_PARAMETERS._PREFILL_PROPERTYID, propId);
                extras.putLong(INTENT_PARAMETERS._PREFILL_PAYMENTID, id);
                intent.putExtras(extras);
                startActivityForIntent(intent);
                finish();
            }
        } else if (StringUtils.isNullOrEmpty(amount)) {
            findViewById(R.id.et_amount).requestFocus();
            showToast(this, "Please fill in the Amount!.");
        } else if (!StringUtils.isNullOrEmpty(mode)
                && mode.equalsIgnoreCase(getString(R.string.cheque))
                && StringUtils.isNullOrEmpty(cheque)) {
            findViewById(R.id.et_cheque).requestFocus();
            showToast(this, "Please provide valid Cheque/DD Number.");
        }

        cursor.close();

    }

    private long insertPayment(String userId, String propId, String taxno, String amount, String pdate, String mode, String cheque) {

        Logger.d(TAG, " @Payment Date" + pdate);

        PaymentContentValues contentValues = new PaymentContentValues();
        contentValues.putUserid(userId);
        contentValues.putPropertyuniqueid(propId);
        contentValues.putTaxno(taxno);
        contentValues.putAmount(amount);
        contentValues.putPdate(Long.toString(System.currentTimeMillis()));
        contentValues.putMode(mode);
        contentValues.putCheque(cheque);
        Uri uri = contentValues.insert(getContentResolver());
        return ContentUris.parseId(uri);
    }
}
