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
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;
import com.orhanobut.logger.Logger;

/**
 * Created by ceinfo on 06-03-2017.
 */

public class PaymentActivity extends BaseActivity {
    private static final String TAG = PaymentActivity.class.getSimpleName();

    private String payableAmount;
    private String propId;

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
    public void setTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) findViewById(R.id.toolbar));

        setTitle("\rPropertyID : " + propId + " Last Synced : " + SharedPrefeHelper.getLastSync(this));

        RadioGroup rgPtop = (RadioGroup) findViewById(R.id.rg_ptp);

        rgPtop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb_pmode_cash:
                    case R.id.rb_pmode_cheque:
                    case R.id.rb_pmode_pos:
                    default:
                        break;
                }
            }
        });

        ((RadioButton) rgPtop.findViewById(R.id.rb_pmode_cash)).setChecked(true);

        findViewById(R.id.et_payment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentOffline();
            }
        });

        ((EditText) findViewById(R.id.et_amount)).setText(payableAmount);
    }

    private void paymentOffline() {

        boolean isValid = true;

        String propId = getIntent().getExtras().getString(INTENT_PARAMETERS._PREFILL_PROPERTYID);

        TaxdetailSelection selection = new TaxdetailSelection();
        selection.propertyid(propId);
        TaxdetailCursor cursor = selection.query(getContentResolver());

        String taxNo = cursor.moveToFirst() ? cursor.getPayableamount() : "";
        String mode = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.rg_ptp)).getCheckedRadioButtonId())).getText().toString();
        String amount = ((EditText) findViewById(R.id.et_amount)).getText().toString();
        String userId = SharedPrefeHelper.getUserId(this);

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

        if (isValid) {

            long id = insertPayment(userId, propId, taxNo, amount, pdate, mode);

            if (id < 0L) {

                //Todo update payment info

            } else {

                Intent intent = new Intent(this, PrintActivity.class);
                Bundle extras = new Bundle();
                extras.putString(INTENT_PARAMETERS._PREFILL_PROPERTYID, propId);
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        } else {
            findViewById(R.id.et_amount).requestFocus();
        }

        cursor.close();

    }

    private long insertPayment(String userId, String propId, String taxno, String amount, String pdate, String mode) {

        Logger.d(TAG, " @Payment Date" + pdate);

        PaymentContentValues contentValues = new PaymentContentValues();
        contentValues.putUserid(userId);
        contentValues.putPropertyuniqueid(propId);
        contentValues.putTaxno(taxno);
        contentValues.putAmount(amount);
        contentValues.putPdate(Long.toString(System.currentTimeMillis()));
        contentValues.putMode(mode);
        Uri uri = contentValues.insert(getContentResolver());
        return ContentUris.parseId(uri);
    }
}
