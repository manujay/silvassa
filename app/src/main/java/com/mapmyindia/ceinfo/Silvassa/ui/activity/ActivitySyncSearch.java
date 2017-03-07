package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.databinding.LayoutActivitySyncsearchBinding;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.DialogHandler;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;

/**
 * Created by ceinfo on 27-02-2017.
 */

public class ActivitySyncSearch extends BaseActivity {

    private static final String TAG = ActivitySyncSearch.class.getSimpleName();

    private LayoutActivitySyncsearchBinding binding;

    @Override
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

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        binding.contentLayout.spinnerRow0.setAdapter(adapter);
        binding.contentLayout.spinnerRow1.setAdapter(adapter);
        binding.contentLayout.spinnerRow2.setAdapter(adapter);
        binding.contentLayout.spinnerRow3.setAdapter(adapter);

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

    private boolean isValidated() {
        boolean isValid = true;

        if (binding.contentLayout.spinnerRow0.getSelectedItemPosition() < 1)
            isValid = false;

        if (binding.contentLayout.spinnerRow1.getSelectedItemPosition() < 1)
            isValid = false;

        if (binding.contentLayout.spinnerRow2.getSelectedItemPosition() < 1)
            isValid = false;

        if (binding.contentLayout.spinnerRow3.getSelectedItemPosition() < 1)
            isValid = false;

        return isValid;
    }
}
