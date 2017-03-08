package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;

/**
 * Created by ceinfo on 07-03-2017.
 */

public class ActivityPrefill extends BaseActivity {

    private static final String TAG = ActivityPrefill.class.getSimpleName();
    private String preString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_prefill);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (null != extras) {
            preString = extras.getString(INTENT_PARAMETERS._PREFILL_KEY);
        }

        findViewByIDs();
    }

    private void findViewByIDs() {
        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setTitle(getResources().getString(R.string.app_name));

        Spinner mPreFillSpinner = (Spinner) findViewById(R.id.spinner_prefill);
        TextView mlableSpinner = (TextView) findViewById(R.id.spinner_label);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

        mPreFillSpinner.setAdapter(adapter);

        if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_ZONE))
            mlableSpinner.setText(getResources().getString(R.string.zone));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
            mlableSpinner.setText(getResources().getString(R.string.owner_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER))
            mlableSpinner.setText(getResources().getString(R.string.occupier_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID))
            mlableSpinner.setText(getResources().getString(R.string.property_id));

        mPreFillSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Log.e(TAG, " @mky:onItemSelected : Position " + position + " : Prefill " + parent.getItemAtPosition(position));

                if (position > 0) {

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();

                    if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_ZONE)) {
                        bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_ZONE);
                    } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER)) {
                        bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_OWNER);
                    } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {
                        bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_OCCUPIER);
                    } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
                        bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_PROPERTYID);
                    }
                    bundle.putString(INTENT_PARAMETERS._PREFILL_RESULT, (String) parent.getItemAtPosition(position));
                    intent.putExtras(bundle);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // empty
            }
        });
    }

    @Override
    public void setTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }
}
