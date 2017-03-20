package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.FilterableRecyclerAdapter;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.RecyclerItemClickListener;
import com.mapmyindia.ceinfo.silvassa.wsmodel.SearchCWSModel;

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
 * Created by ceinfo on 07-03-2017.
 */

public class ActivityPrefill extends BaseActivity {

    private static final String TAG = ActivityPrefill.class.getSimpleName();
    private String preString;
    private ArrayList<String> mFilterableList = new ArrayList<>();
    private FilterableRecyclerAdapter recyclerAdapter;
    private AppCompatEditText mSearchableEditText;

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

        if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_ZONE))
            setTitle(getResources().getString(R.string.zone));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
            setTitle(getResources().getString(R.string.owner_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER))
            setTitle(getResources().getString(R.string.occupier_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID))
            setTitle(getResources().getString(R.string.property_id));

        doPost();
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setTitle(getResources().getString(R.string.app_name));

        if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_ZONE))
            setTitle(getResources().getString(R.string.zone));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
            setTitle(getResources().getString(R.string.owner_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER))
            setTitle(getResources().getString(R.string.occupier_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID))
            setTitle(getResources().getString(R.string.property_id));

        mSearchableEditText = (AppCompatEditText) findViewById(R.id.search_et);

        mSearchableEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                recyclerAdapter.getFilter().filter(s.toString());
            }
        });

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerAdapter = new FilterableRecyclerAdapter(ActivityPrefill.this, mFilterableList);

        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemAtPosition = ((TextView) (recyclerView.getChildAt(position)).findViewById(R.id.item_tv)).getText().toString();

                setResult(itemAtPosition);
            }
        }));
    }

    private void setResult(String itemAtPosition) {

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
        for (int i = 0; i < 20; i++) {
            mFilterableList.add(String.format(Locale.getDefault(), "%s", getResources().getStringArray(R.array.filterable_array)[i]));
            recyclerAdapter.notifyDataSetChanged();
        }
    }

    private void getSearchCriteria(String zoneId) {

        RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);
        Call<ResponseBody> call = apiClient.getSearchCriteria(zoneId);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        ArrayList<SearchCWSModel> data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<ArrayList<SearchCWSModel>>() {
                        }.getType());

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
}
