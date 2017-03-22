package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.AdapterExpandableListView;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;
import com.mapmyindia.ceinfo.silvassa.wsmodel.PropertWSModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ceinfo on 01-03-2017.
 */

public class ActivityResults extends BaseActivity {

    private static final String TAG = ActivityResults.class.getSimpleName();
    ProgressBar progressBar;
    AppCompatButton mPayNowButton, mBackToResults;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_result);

        findViewByIDs();

        Bundle extras = getIntent().getExtras();

//        if (null != extras && extras.containsKey(INTENT_PARAMETERS._POSTJSONPAYLOAD)) {
//
//            String payload = extras.getString(INTENT_PARAMETERS._POSTJSONPAYLOAD);
//
//            if (!Connectivity.isConnected(this)) {
//
//                showSnackBar(getWindow().getDecorView(), getString(R.string.error_network));
//
//            } else {
//
//                SearchPropertyForCriteria(payload);
//
//            }
//
//        }

    }

    @Override
    public void setTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) findViewById(R.id.toolbar));

        setTitle(getResources().getString(R.string.app_name));

        List<String> listDataHeader = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            listDataHeader.add("S" + System.currentTimeMillis() / 1000);
        }

        HashMap<String, List<String>> listChildData = new HashMap<>();

        for (String e : listDataHeader) {
            List<String> childlist = new ArrayList<>();
            childlist.add(String.format(Locale.getDefault(), "Property ID   :%s", e));
            childlist.add(String.format(Locale.getDefault(), "Name          :%s", getString(R.string.app_name)));
            childlist.add(String.format(Locale.getDefault(), "Father's Name :%s", getString(R.string.app_name)));
            childlist.add(String.format(Locale.getDefault(), "Address       :%s", getString(R.string.app_name)));
            childlist.add(String.format(Locale.getDefault(), "Email         :%s", getString(R.string.app_name)));
            childlist.add(String.format(Locale.getDefault(), "Phone No.     :%s", getString(R.string.app_name)));

            listChildData.put(e, childlist);
        }

        final ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_list);
        final AdapterExpandableListView mAdapterExpandListView = new AdapterExpandableListView(this, listDataHeader, listChildData);

        expandableListView.setAdapter(mAdapterExpandListView);

        mPayNowButton = (AppCompatButton) findViewById(R.id.et_pay_buttom);
        mBackToResults = (AppCompatButton) findViewById(R.id.et_back_button);

        ViewUtils.setColorToView("#bc0807", mPayNowButton);
        ViewUtils.setColorToView("#4c4b97", mBackToResults);

        mPayNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Connectivity.isConnected(ActivityResults.this)) {
                    Snackbar.make(getWindow().getDecorView(), R.string.error_network, Snackbar.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(ActivityResults.this, ActivityPayment.class));
                }
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (mBackToResults.getVisibility() == View.GONE) {
                    mBackToResults.setVisibility(View.VISIBLE);
                }
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                if (mBackToResults.getVisibility() == View.VISIBLE) {
                    mBackToResults.setVisibility(View.GONE);
                }
            }
        });

        mBackToResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo Collapse expanded group
            }
        });

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

    private void SearchPropertyForCriteria(String pojo) {

        RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);
        Call<ResponseBody> call = apiClient.searchProperty(pojo);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    showProgress(false);

                    try {

                        JSONObject jsonObject = new JSONObject(response.body().string());

                        if (!jsonObject.getString("message").equalsIgnoreCase("Success")) {
                            Snackbar.make(getWindow().getDecorView(), R.string.error_server, Snackbar.LENGTH_SHORT);
                            return;
                        }

                        if (Integer.parseInt(jsonObject.getString("status")) != 200) {
                            Snackbar.make(getWindow().getDecorView(), R.string.error_server, Snackbar.LENGTH_SHORT);
                            return;
                        }

                        if (null == jsonObject.get("data")) {
                            Snackbar.make(getWindow().getDecorView(), R.string.error_server, Snackbar.LENGTH_SHORT);
                            return;
                        }

                        ArrayList<PropertWSModel> data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<ArrayList<PropertWSModel>>() {
                        }.getType());

                        Log.d(TAG, " @SearchPropertyForCriteria: " + data);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Log.d(TAG, " @SearchPropertyForCriteria : SUCCESS : " + response.body());

                } else {

                    Log.e(TAG, " @SearchPropertyForCriteria : FAILURE : " + call.request());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, " @SearchPropertyForCriteria : FAILURE : " + call.request());
            }
        });

        showProgress(true);
    }
}
