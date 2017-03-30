package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
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
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;

/**
 * Created by ceinfo on 06-03-2017.
 */

public class PaymentActivity extends BaseActivity {
    private static final String TAG = PaymentActivity.class.getSimpleName();

    private AppCompatButton mProceedButton;
    private String payableAmount;
    private String taxNo;
    private String pdate;
    private String propId;
    private EditText et_payment;

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
                taxNo = cursor.getTaxno();
                pdate = cursor.getDuedate();
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

        setTitle("PropertyID : " + propId + " TaxNo : " + taxNo + " Last Synced : " + SharedPrefeHelper.getLastSync(this));

        RadioGroup rgPtop = (RadioGroup) findViewById(R.id.rg_ptp);

        rgPtop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_pmode_cash:
                    case R.id.rb_pmode_cheque:
                    default:
//                        doPost();
                        break;
                }
            }
        });

        ((RadioButton) rgPtop.findViewById(R.id.rb_pmode_cash)).setChecked(true);

        mProceedButton = (AppCompatButton) findViewById(R.id.et_payment_button);

        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentOffline();
            }
        });

        et_payment = (EditText) findViewById(R.id.et_amount);

        et_payment.setText(payableAmount);

    }

    private void paymentOffline() {
        Bundle extras = getIntent().getExtras();

        if (null != extras && extras.containsKey(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {

            insertPayment(propId, payableAmount, taxNo, pdate);
        }
    }

    private long insertPayment(String propId, String payableAmount, String taxNo, String pdate) {
        PaymentContentValues contentValues = new PaymentContentValues();
        contentValues.putPayableamount(payableAmount);
        contentValues.putPropertyuniqueid(propId);
        contentValues.putAmount(et_payment.getText().toString());
        contentValues.putTaxno(taxNo);
        contentValues.putPdate(pdate);
        Uri uri = contentValues.insert(getContentResolver());
        return ContentUris.parseId(uri);
    }
}
