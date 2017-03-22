package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.AdapterExpandableListView;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
}
