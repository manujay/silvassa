package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.databinding.LayoutActivitySyncsearchBinding;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.DialogHandler;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;

/**
 * Created by ceinfo on 27-02-2017.
 */

public class ActivitySyncSearch extends BaseActivity implements View.OnClickListener {

    private static final String TAG = ActivitySyncSearch.class.getSimpleName();

    private LayoutActivitySyncsearchBinding binding;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_syncsearch);

        findViewByIDs();
    }

    @Override
    public void setTitle(String mTitle) {
        binding.toolbar.setMTitle(mTitle);
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) binding.toolbar.getRoot());

        setTitle(getResources().getString(R.string.app_name));

        ViewUtils.setColorToView("#bc0807", binding.contentLayout.etSearchButton);
        ViewUtils.setColorToView("#4c4b97", binding.contentLayout.etSyncButton);

        binding.contentLayout.etSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidated()) {
                    startActivity(new Intent(ActivitySyncSearch.this, ActivityResults.class));
//                    finish();
                } else {
                    new DialogHandler(ActivitySyncSearch.this).showAlertDialog("Please select \nOwner Name, Occupier Name or Property ID");
                }
            }
        });

        binding.contentLayout.etSyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Connectivity.isConnected(ActivitySyncSearch.this)) {
                    Snackbar.make(getWindow().getDecorView(), "No Internet Connectivity", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();

        switch (v.getId()) {
            case R.id.spinner_row0:
                bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_ZONE);
                break;
            case R.id.spinner_row1:
                bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_OWNER);
                break;
            case R.id.spinner_row2:
                bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_OCCUPIER);
                break;
            case R.id.spinner_row3:
                bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_PROPERTYID);
                break;
            default:
                break;
        }

        Intent intent = new Intent(ActivitySyncSearch.this, ActivityPrefill.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, INTENT_PARAMETERS._PREFILL_REQUEST);
    }

    private boolean isValidated() {
        boolean isValid = true;

        String zone = binding.contentLayout.spinnerRow0.getText().toString();
        String owner = binding.contentLayout.spinnerRow1.getText().toString();
        String occupier = binding.contentLayout.spinnerRow2.getText().toString();
        String property_id = binding.contentLayout.spinnerRow3.getText().toString();

        if (TextUtils.isEmpty(zone))
            isValid = false;

        if (TextUtils.isEmpty(owner))
            isValid = false;

        if (TextUtils.isEmpty(occupier))
            isValid = false;

        if (TextUtils.isEmpty(property_id))
            isValid = false;

        return isValid;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case INTENT_PARAMETERS._PREFILL_REQUEST:
                    if (null != data && null != data.getExtras()) {
                        Bundle bundle = data.getExtras();
                        String key = bundle.getString(INTENT_PARAMETERS._PREFILL_KEY);
                        String value = bundle.getString(INTENT_PARAMETERS._PREFILL_RESULT);
                        if (null != key) {
                            if (key.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_ZONE))
                                binding.contentLayout.spinnerRow0.setText(value);
                            else if (key.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
                                binding.contentLayout.spinnerRow1.setText(value);
                            else if (key.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER))
                                binding.contentLayout.spinnerRow2.setText(value);
                            else if (key.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID))
                                binding.contentLayout.spinnerRow3.setText(value);
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
