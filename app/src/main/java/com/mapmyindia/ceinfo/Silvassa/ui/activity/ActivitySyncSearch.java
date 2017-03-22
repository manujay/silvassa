package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.databinding.LayoutActivitySyncsearchBinding;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneColumns;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneCursor;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneSelection;
import com.mapmyindia.ceinfo.silvassa.sync.SyncProvider;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.DialogHandler;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;

import java.util.Locale;

/**
 * Created by ceinfo on 27-02-2017.
 */

public class ActivitySyncSearch extends BaseActivity implements View.OnClickListener {

    private static final String TAG = ActivitySyncSearch.class.getSimpleName();
    private static final int INIT_ZONE_LOADER = 12212;
    ProgressBar progressBar;
    private LayoutActivitySyncsearchBinding binding;
    private SyncSpinnerAdapter spinnerAdapter;

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
                if (isValidate()) {
                    startActivity(new Intent(ActivitySyncSearch.this, ActivityResults.class));
                } else {
                    new DialogHandler(ActivitySyncSearch.this).showAlertDialog("Please select \nOwner Name, Occupier Name or Property ID");
                }
            }
        });

        binding.contentLayout.etSyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Connectivity.isConnected(ActivitySyncSearch.this)) {
                    showSnackBar(getWindow().getDecorView(), getString(R.string.error_network));
                } else {
                    doPost();
                }
            }
        });

        spinnerAdapter = new SyncSpinnerAdapter(this, null);

        binding.contentLayout.spinnerRow0.setAdapter(spinnerAdapter);

        binding.contentLayout.spinnerRow0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ZoneCursor cursor = ((ZoneCursor) ((SyncSpinnerAdapter) parent.getAdapter()).getCursor());

                if (cursor.moveToFirst())
                    SharedPrefeHelper.setZoneId(ActivitySyncSearch.this, cursor.getZoneid());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        populateZoneSpinnerAdapter();
    }

    private void populateZoneSpinnerAdapter() {
        getSupportLoaderManager().initLoader(INIT_ZONE_LOADER, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                ZoneSelection selection = new ZoneSelection();
                return selection.getCursorLoader(ActivitySyncSearch.this);
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
                ZoneCursor cursor = new ZoneCursor(data);
                spinnerAdapter.changeCursor(cursor);
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {
                spinnerAdapter.swapCursor(null);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();

        switch (v.getId()) {
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

        ZoneCursor zoneCursor = (ZoneCursor) spinnerAdapter.getItem(binding.contentLayout.spinnerRow0.getSelectedItemPosition());

        if (zoneCursor.moveToFirst())
            bundle.putString(INTENT_PARAMETERS._PREFILL_ZONE, zoneCursor.getZoneid());

        Intent intent = new Intent(ActivitySyncSearch.this, ActivityPrefill.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, INTENT_PARAMETERS._PREFILL_REQUEST);
    }

    private void showProgress(boolean show) {
        if (null == progressBar) {
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
        }
        if (show && progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private boolean isValidate() {
        boolean isValid = true;

        ZoneCursor zoneCursor = (ZoneCursor) spinnerAdapter.getItem(binding.contentLayout.spinnerRow0.getSelectedItemPosition());
        zoneCursor.moveToFirst();

        String zoneId = !TextUtils.isEmpty(SharedPrefeHelper.getZoneId(this)) ? SharedPrefeHelper.getZoneId(this) : zoneCursor.getZoneid();
        String owner = binding.contentLayout.spinnerRow1.getText().toString();
        String occupier = binding.contentLayout.spinnerRow2.getText().toString();
        String property_id = binding.contentLayout.spinnerRow3.getText().toString();

        if (TextUtils.isEmpty(zoneId))
            isValid = false;

        if (TextUtils.isEmpty(owner))
            isValid = false;

        if (TextUtils.isEmpty(occupier))
            isValid = false;

        if (TextUtils.isEmpty(property_id))
            isValid = false;

        return isValid;
    }

    private void doPost() {

        showProgress(true);

        boolean isValid = false;

        ZoneCursor zoneCursor = (ZoneCursor) spinnerAdapter.getItem(binding.contentLayout.spinnerRow0.getSelectedItemPosition());
        zoneCursor.moveToFirst();

        String zoneId = !TextUtils.isEmpty(SharedPrefeHelper.getZoneId(this)) ? SharedPrefeHelper.getZoneId(this) : zoneCursor.getZoneid();

        if (!TextUtils.isEmpty(zoneId))
            isValid = true;

        if (isValid) {

            String payload = payload("", "", "", zoneId);

            SyncProvider.getInstance(ActivitySyncSearch.this).performSync(new SyncProvider.SyncProviderListener() {
                @Override
                public void onSyncResponse(String msg) {
                    showProgress(false);
                    showToast(ActivitySyncSearch.this, msg);
                }

                @Override
                public void onSyncError(String msg) {
                    showProgress(false);
                    showSnackBar(getWindow().getDecorView(), msg);
                }
            }, payload);

        } else {
            new DialogHandler(ActivitySyncSearch.this).showAlertDialog("Please select \nOwner Name, Occupier Name or Property ID");
        }
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
                            if (key.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
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

    private String payload(String propertId, String occupier, String ownerName, String zoneId) {

        //{"zoneId":"05","ownerName":"","occupierName":"","propertyId":""}
        Payload payload = new Payload();
        payload.setZoneId(zoneId);
        payload.setOwnerName(ownerName);
        payload.setOccupierName(occupier);
        payload.setPropertyId(propertId);

        String toJson = new Gson().toJson(payload, Payload.class);

        Log.d(TAG, " @payload:toJson : " + toJson);

        return toJson;
    }

    public class SyncSpinnerAdapter extends CursorAdapter {

        public SyncSpinnerAdapter(Context context, Cursor cursor) {
            super(context, cursor, 0);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.layout_recycler_single_item, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            AppCompatTextView textView = (AppCompatTextView) view.findViewById(R.id.item_tv);
            textView.setText(String.format(Locale.getDefault(), "%s", cursor.getString(cursor.getColumnIndexOrThrow(ZoneColumns.ZONENAME))));
        }
    }

    class Payload {
        String zoneId;
        String ownerName;
        String occupierName;
        String propertyId;

        public String getZoneId() {
            return zoneId;
        }

        public void setZoneId(String zoneId) {
            this.zoneId = zoneId;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getOccupierName() {
            return occupierName;
        }

        public void setOccupierName(String occupierName) {
            this.occupierName = occupierName;
        }

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }
    }
}