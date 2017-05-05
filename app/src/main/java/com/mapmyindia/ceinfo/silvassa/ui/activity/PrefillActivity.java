package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FilterQueryProvider;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.FilterRecyclerAdapter;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.RecyclerItemClickListener;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;

/**
 * Created by ceinfo on 07-03-2017.
 */

public class PrefillActivity extends BaseActivity {

    private static final String TAG = PrefillActivity.class.getSimpleName();
    private static final int INIT_PREFILL_ADAPTER = 10010;
    private String preString;
    private FilterRecyclerAdapter filterableCursorAdapter;
    private RecyclerView recyclerView;

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

        populatePrefillAdapter();
    }

    private void setfilterQueryProvider() {
        filterableCursorAdapter.setFilterQueryProvider(new FilterQueryProvider() {

            @Override
            public Cursor runQuery(CharSequence constraint) {

                PropertySelection selection = new PropertySelection();

                if (constraint.length() > 0) {
                    if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER)) {
                        selection.propertyownerContains(constraint.toString().toLowerCase());
                    } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {
                        selection.propertyoccupiernameContains(constraint.toString().toLowerCase());
                    } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
                        selection.propertyuniqueidContains(constraint.toString().toLowerCase());
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

                PropertySelection selection = new PropertySelection();

                if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER)) {
                    return selection.getCursorLoader(PrefillActivity.this, new String[]{PropertyColumns._ID, PropertyColumns.PROPERTYOWNER});
                } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {
                    return selection.getCursorLoader(PrefillActivity.this, new String[]{PropertyColumns._ID, PropertyColumns.PROPERTYOCCUPIERNAME});
                } else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
                    return selection.getCursorLoader(PrefillActivity.this, new String[]{PropertyColumns._ID, PropertyColumns.PROPERTYUNIQUEID});
                }

                return selection.getCursorLoader(PrefillActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
                if (null == filterableCursorAdapter) {
                    filterableCursorAdapter = new FilterRecyclerAdapter(PrefillActivity.this, data).setBundleExtras(getIntent().getExtras());
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
        setSupportActionBar(getToolbar());

        if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
            setmTitle(getResources().getString(R.string.owner_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER))
            setmTitle(getResources().getString(R.string.occupier_name));
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID))
            setmTitle(getResources().getString(R.string.property_id));

        final AppCompatEditText mSearchableEditText = (AppCompatEditText) findViewById(R.id.search_et);

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

        mSearchableEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    mButtonLogin.performClick();
                    ViewUtils.hideKeyboardFrom(PrefillActivity.this, mSearchableEditText.getRootView());
                    return true;
                }
                return false;
            }
        });

        if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER))
            mSearchableEditText.setHint(R.string.string_hint_search_owner);
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER))
            mSearchableEditText.setHint(R.string.string_hint_search_occupier);
        else if (preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID))
            mSearchableEditText.setHint(R.string.string_hint_search_property);

        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        filterableCursorAdapter = new FilterRecyclerAdapter(PrefillActivity.this, null).setBundleExtras(getIntent().getExtras());

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
    public void setmTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }
}
