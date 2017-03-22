package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
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
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.databinding.LayoutActivitySyncsearchBinding;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneColumns;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneCursor;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneSelection;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.DialogHandler;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;
import com.mapmyindia.ceinfo.silvassa.wsmodel.ZoneWSModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ceinfo on 27-02-2017.
 */

public class ActivitySyncSearch extends BaseActivity implements View.OnClickListener {

    private static final String TAG = ActivitySyncSearch.class.getSimpleName();
    private static final int INIT_ZONE_LOADER = 12212;
    private LayoutActivitySyncsearchBinding binding;
    private SyncSpinnerAdapter spinnerAdapter;
    private ProgressBar progressBar;

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

    private boolean isValidated() {
        boolean isValid = true;

        String owner = binding.contentLayout.spinnerRow1.getText().toString();
        String occupier = binding.contentLayout.spinnerRow2.getText().toString();
        String property_id = binding.contentLayout.spinnerRow3.getText().toString();

//        if (binding.contentLayout.spinnerRow0.getSelectedItemPosition() < 1)
//            isValid = false;

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

    private void getZone() {
        RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);

        Call<ResponseBody> call = apiClient.getZone();

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        ArrayList<ZoneWSModel> data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<ArrayList<ZoneWSModel>>() {
                        }.getType());

                        for (ZoneWSModel zoneWSModel : data) {
                            insertZone(zoneWSModel.getZoneName(), zoneWSModel.getZoneId());
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Log.d(TAG, " @getZone : SUCCESS : " + response.body());

                } else {
                    Log.e(TAG, " @getZone : FAILURE : " + call.request());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, " @getZone : FAILURE : " + call.request());
            }
        });
    }

    private long insertZone(String zoneName, String zoneId) {
        ZoneContentValues contentValues = new ZoneContentValues();
        contentValues.putZoneid(zoneId);
        contentValues.putZonename(zoneName);
        Uri uri = contentValues.insert(getContentResolver());
        return ContentUris.parseId(uri);
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
}