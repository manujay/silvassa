package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.FilterableRecyclerAdapter;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by ceinfo on 07-03-2017.
 */

public class ActivityPrefill extends BaseActivity {

    private static final String TAG = ActivityPrefill.class.getSimpleName();
    private String preString;
    private ArrayList<String> mFilterableList = new ArrayList<>();
    private FilterableRecyclerAdapter recyclerAdapter;
    private SearchView mSearchableEditText;

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

        mSearchableEditText = (SearchView) findViewById(R.id.search_et);

        mSearchableEditText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
                    recyclerAdapter.getFilter().filter(newText);
                    return true;
                }
                return false;
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new FilterableRecyclerAdapter(ActivityPrefill.this, mFilterableList);

        recyclerView.setAdapter(recyclerAdapter);
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
            mFilterableList.add(String.format(Locale.getDefault(), "ID%d", (System.currentTimeMillis() / 1000) - i));
            recyclerAdapter.notifyDataSetChanged();
        }
    }
}
