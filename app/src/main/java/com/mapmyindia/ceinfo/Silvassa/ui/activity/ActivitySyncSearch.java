package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;

/**
 * Created by ceinfo on 27-02-2017.
 */

public class ActivitySyncSearch extends BaseActivity {

    private static final String TAG = ActivitySyncSearch.class.getSimpleName();

    private AppCompatButton mSyncButton, mSearchButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.layout_activity_syncsearch);
        initViews();

        super.onCreate(savedInstanceState);
    }

    private void initViews() {
        mSearchButton = (AppCompatButton) findViewById(R.id.et_search_button);
        mSyncButton = (AppCompatButton) findViewById(R.id.et_sync_button);

        ViewUtils.setColorToView("#bc0807", mSearchButton);
        ViewUtils.setColorToView("#4c4b97", mSyncButton);

        Spinner spinner_row0 = (Spinner) findViewById(R.id.spinner_row0);
        Spinner spinner_row1 = (Spinner) findViewById(R.id.spinner_row1);
        Spinner spinner_row2 = (Spinner) findViewById(R.id.spinner_row2);
        Spinner spinner_row3 = (Spinner) findViewById(R.id.spinner_row3);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_row0.setAdapter(adapter);
        spinner_row1.setAdapter(adapter);
        spinner_row2.setAdapter(adapter);
        spinner_row3.setAdapter(adapter);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivitySyncSearch.this, ActivityResults.class));
                finish();
            }
        });
    }
}
