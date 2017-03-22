package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.FilterQueryProvider;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.FilterableCursorRecyclerAdapter;
import com.mapmyindia.ceinfo.silvassa.provider.criteria.CriteriaColumns;
import com.mapmyindia.ceinfo.silvassa.provider.criteria.CriteriaContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.criteria.CriteriaSelection;
import com.mapmyindia.ceinfo.silvassa.provider.occupier.OccupierContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.owner.OwnerContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyContentValues;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.RecyclerItemClickListener;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.wsmodel.SearchCWSModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ceinfo on 07-03-2017.
 */

public class ActivityPrefill extends BaseActivity {

    private static final String TAG = ActivityPrefill.class.getSimpleName();
    private static final int INIT_PREFILL_ADAPTER = 10010;
    private String preString;
    private String zoneID;
    private FilterableCursorRecyclerAdapter filterableCursorAdapter;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_prefill);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (null != extras) {
            preString = extras.getString(INTENT_PARAMETERS._PREFILL_KEY);
            zoneID = extras.getString(INTENT_PARAMETERS._PREFILL_ZONE);
        }

        findViewByIDs();

        doPost();

        populatePrefillAdapter();
    }

    private void setfilterQueryProvider() {
        filterableCursorAdapter.setFilterQueryProvider(new FilterQueryProvider() {

            @Override
            public Cursor runQuery(CharSequence constraint) {

                CriteriaSelection selection = new CriteriaSelection();

                if (constraint.length() > 0) {
                    if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER)) {
                        selection.ownernameContains(constraint.toString().toLowerCase());
                    } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {
                        selection.occupiernameContains(constraint.toString().toLowerCase());
                    } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
                        selection.propidContains(constraint.toString().toLowerCase());
                    }
                }
                return selection.query(getContentResolver());
            }
        });
    }

    private void populatePrefillAdapter() {
        getSupportLoaderManager().initLoader(INIT_PREFILL_ADAPTER, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {

                CriteriaSelection selection = new CriteriaSelection();

                if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER)) {
                    return selection.getCursorLoader(ActivityPrefill.this, new String[]{CriteriaColumns._ID, CriteriaColumns.OWNERNAME});
                } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {
                    return selection.getCursorLoader(ActivityPrefill.this, new String[]{CriteriaColumns._ID, CriteriaColumns.OCCUPIERNAME});
                } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
                    return selection.getCursorLoader(ActivityPrefill.this, new String[]{CriteriaColumns._ID, CriteriaColumns.PROPID});
                }

                return null;
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
                if (null == filterableCursorAdapter) {
                    filterableCursorAdapter = new FilterableCursorRecyclerAdapter(ActivityPrefill.this, data).setBundleExtras(getIntent().getExtras());
                    recyclerView.setAdapter(filterableCursorAdapter);
                    setfilterQueryProvider();
                }

                filterableCursorAdapter.changeCursor(data);
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {
                filterableCursorAdapter.swapCursor(null);
            }
        });
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setTitle(getResources().getString(R.string.app_name));

        if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
            setTitle(getResources().getString(R.string.owner_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER))
            setTitle(getResources().getString(R.string.occupier_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID))
            setTitle(getResources().getString(R.string.property_id));

        AppCompatEditText mSearchableEditText = (AppCompatEditText) findViewById(R.id.search_et);

        mSearchableEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filterableCursorAdapter.getFilter().filter(s.toString());
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        filterableCursorAdapter = new FilterableCursorRecyclerAdapter(ActivityPrefill.this, null).setBundleExtras(getIntent().getExtras());

        setfilterQueryProvider();

        recyclerView.setAdapter(filterableCursorAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemAtPosition = ((TextView) view.findViewById(R.id.item_tv)).getText().toString();

                setResult(itemAtPosition);
            }
        }));
    }

    private void setResult(String itemAtPosition) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER)) {
            bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_OWNER);
        } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {
            bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_OCCUPIER);
        } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
            bundle.putString(INTENT_PARAMETERS._PREFILL_KEY, INTENT_PARAMETERS._PREFILL_PROPERTYID);
        }
        bundle.putString(INTENT_PARAMETERS._PREFILL_RESULT, itemAtPosition);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void setTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }

    private void doPost() {
        if (null != zoneID && !TextUtils.isEmpty(zoneID))
            getSearchCriteria(zoneID);
        else
            getSearchCriteria(SharedPrefeHelper.getZoneId(this));
    }

    private void getSearchCriteria(String zoneId) {

        RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);
        Call<ResponseBody> call = apiClient.getSearchCriteria(zoneId);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    showProgress(false);

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        SearchCWSModel data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<SearchCWSModel>() {
                        }.getType());

                        for (int i = 0; i < data.getPropIdArr().size() && i < data.getOccupierArr().size() && i < data.getOwnerArr().size(); i++) {
                            insertCriteria(data.getOwnerArr().get(i), data.getPropIdArr().get(i), data.getOccupierArr().get(i));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Log.d(TAG, " @getSearchCriteria : SUCCESS : " + response.body());

                } else {

                    Log.e(TAG, " @getSearchCriteria : FAILURE : " + call.request());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, " @getSearchCriteria : FAILURE : " + call.request());
            }
        });

        showProgress(true);
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

    private long insertCriteria(String owner, String propertyId, String occupier) {
        CriteriaContentValues contentValues = new CriteriaContentValues();
        contentValues.putOccupiername(occupier);
        contentValues.putOwnername(owner);
        contentValues.putPropid(propertyId);
        Uri uri = contentValues.insert(this.getContentResolver());
        return ContentUris.parseId(uri);
    }

    private long insertOwner(String owner) {
        OwnerContentValues contentValues = new OwnerContentValues();
        contentValues.putOwnername(owner);
        Uri uri = contentValues.insert(this.getContentResolver());
        return ContentUris.parseId(uri);
    }

    private long insertOccupier(String occupier) {
        OccupierContentValues contentValues = new OccupierContentValues();
        contentValues.putOccupiername(occupier);
        Uri uri = contentValues.insert(this.getContentResolver());
        return ContentUris.parseId(uri);
    }

    private long insertProperty(String propertyid) {
        PropertyContentValues contentValues = new PropertyContentValues();
        contentValues.putPropertyuniqueid(propertyid);
        Uri uri = contentValues.insert(this.getContentResolver());
        return ContentUris.parseId(uri);
    }
}
