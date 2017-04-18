package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.ResultsCursorAdapter;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.ui.fragment.PlaceHolderFragment;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.RecyclerItemClickListener;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;

/**
 * Created by ceinfo on 01-03-2017.
 */

public class ResultsActivity extends BaseActivity {

    private static final String TAG = ResultsActivity.class.getSimpleName();
    private static final int INIT_RESULTS_LOADER = 110254;
    private String zoneId, occupier, owner, propertyId;
    private RecyclerView recyclerView;
    private ResultsCursorAdapter resultsCursorAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (null != getIntent().getExtras()) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey(INTENT_PARAMETERS._PREFILL_ZONE)) {
                zoneId = extras.getString(INTENT_PARAMETERS._PREFILL_ZONE);
            }
            if (extras.containsKey(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {
                occupier = extras.getString(INTENT_PARAMETERS._PREFILL_OCCUPIER);
            }
            if (extras.containsKey(INTENT_PARAMETERS._PREFILL_OWNER)) {
                owner = extras.getString(INTENT_PARAMETERS._PREFILL_OWNER);
            }
            if (extras.containsKey(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
                propertyId = extras.getString(INTENT_PARAMETERS._PREFILL_PROPERTYID);
            }
        }

        setContentView(R.layout.layout_activity_result);

        findViewByIDs();

        populateResults();

    }

    @Override
    protected void onDestroy() {

        getSupportLoaderManager().destroyLoader(INIT_RESULTS_LOADER);

        super.onDestroy();
    }

    private void populateResults() {
        getSupportLoaderManager().initLoader(INIT_RESULTS_LOADER, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                PropertySelection selection = new PropertySelection();

                if (!StringUtils.isNullOrEmpty(zoneId)) {
                    selection.zoneidContains(zoneId);
                }

                if (!StringUtils.isNullOrEmpty(propertyId)) {
                    selection.and().propertyuniqueidContains(propertyId);
                }

                if (!StringUtils.isNullOrEmpty(owner)) {
                    selection.and().propertyownerContains(owner);
                }

                if (!StringUtils.isNullOrEmpty(occupier)) {
                    selection.and().propertyoccupiernameContains(occupier);
                }

                return selection.getCursorLoader(ResultsActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
                PropertyCursor cursor = new PropertyCursor(data);

                if (null == resultsCursorAdapter) {
                    resultsCursorAdapter = new ResultsCursorAdapter(cursor);
                    recyclerView.setAdapter(resultsCursorAdapter);
                }

                /* handle empty results */

                if (cursor.getCount() > 1) {

                    if (recyclerView.getVisibility() == View.GONE) {
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                    findViewById(R.id.empty_tv).setVisibility(View.GONE);

                } else if (cursor.getCount() > 0) {

                    /* set back to default*/

                    if (recyclerView.getVisibility() == View.VISIBLE) {
                        recyclerView.setVisibility(View.GONE);
                    }

                    findViewById(R.id.empty_tv).setVisibility(View.GONE);

                    if (cursor.moveToFirst()) {
                        final String propertyId = cursor.getString(cursor.getColumnIndexOrThrow(PropertyColumns.PROPERTYUNIQUEID));

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                showTaxDetails(propertyId);
                            }
                        });
                    }
                } else {
                    findViewById(R.id.empty_tv).setVisibility(View.VISIBLE);
                }

                resultsCursorAdapter.changeCursor(cursor);
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {
                resultsCursorAdapter.swapCursor(null);
            }
        });
    }

    @Override
    public void setmTitle(String mTitle) {
        getToolbar().setSubtitle(mTitle);
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) findViewById(R.id.toolbar));

        setmTitle("Last Synced: " + SharedPrefeHelper.getLastSync(ResultsActivity.this));

        setSupportActionBar(getToolbar());

        recyclerView = (RecyclerView) findViewById(R.id.expandable_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        resultsCursorAdapter = new ResultsCursorAdapter(null);

        recyclerView.setAdapter(resultsCursorAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                String propertyId = view.getTag().toString();

                showTaxDetails(propertyId);
            }
        }));
    }

    private void showTaxDetails(String propertyId) {
        replaceFragmentWithAnimation(PlaceHolderFragment.getInstance(propertyId), PlaceHolderFragment.TAG, true, true);
    }

    public void replaceFragmentWithAnimation(Fragment fragment, String tag, boolean animate, boolean addToBackStack) {

        PlaceHolderFragment oldfragment = (PlaceHolderFragment) getSupportFragmentManager().findFragmentById(R.id.frame_results);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (animate) {
            ft.setCustomAnimations(R.anim.enter_from_right, 0, 0, R.anim.exit_to_left);
        }

        if (null == oldfragment) {
            ft.add(R.id.frame_results, fragment, tag);
        } else {
            ft.replace(R.id.frame_results, fragment, tag);
        }

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }

        ft.commit();
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1)
            getSupportFragmentManager().popBackStack();

        if (null != resultsCursorAdapter && resultsCursorAdapter.getItemCount() == 1) {
            finish();
        } else
            super.onBackPressed();
    }


}
