package com.mapmyindia.ceinfo.sivassa.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ExpandableListView;

import com.mapmyindia.ceinfo.sivassa.R;
import com.mapmyindia.ceinfo.sivassa.adapter.AdapterExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by ceinfo on 01-03-2017.
 */

public class ActivityResults extends BaseActivity {

    private static final String TAG = ActivityResults.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.layout_activity_result);

        findViewById();

        super.onCreate(savedInstanceState);
    }

    private void findViewById() {

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

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_list);
        AdapterExpandableListView mAdapterExpandListView = new AdapterExpandableListView(this, listDataHeader, listChildData);

        expandableListView.setAdapter(mAdapterExpandListView);
    }
}
