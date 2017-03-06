package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;

/**
 * Created by ceinfo on 06-03-2017.
 */

public class ActivityPayment extends BaseActivity {
    private static final String TAG = ActivityPayment.class.getSimpleName();

    AppCompatButton mProceedButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.layout_activity_payment);

        findViewByID();

        super.onCreate(savedInstanceState);
    }

    private void findViewByID() {

        RadioGroup rgPtop = (RadioGroup) findViewById(R.id.rg_ptp);

        rgPtop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_pmode_cash:
                    case R.id.rb_pmode_cheque:
                    default:
                        doPost();
                        break;
                }
            }
        });

        ((RadioButton) rgPtop.findViewById(R.id.rb_pmode_cash)).setChecked(true);

        mProceedButton = (AppCompatButton) findViewById(R.id.et_payment_button);

        ViewUtils.setColorToView("#bc0807", mProceedButton);

        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Connectivity.isConnected(ActivityPayment.this)) {
                    Snackbar.make(getWindow().getDecorView(), "No Internet Connectivity", Snackbar.LENGTH_SHORT).show();
                } else {
                    doPost();
                }
            }
        });
    }

    private void doPost() {
        //Todo Payment model initialization
    }
}
