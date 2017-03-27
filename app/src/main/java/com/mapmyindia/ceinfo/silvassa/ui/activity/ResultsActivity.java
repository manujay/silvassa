package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.adapter.ResultsCursorAdapter;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailColumns;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailCursor;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailSelection;
import com.mapmyindia.ceinfo.silvassa.utils.DateTimeUtils;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.RecyclerItemClickListener;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;

import java.util.Locale;

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

                if (cursor.getCount() > 1) {

                    if (recyclerView.getVisibility() == View.GONE) {
                        recyclerView.setVisibility(View.VISIBLE);
                    }

                } else if (cursor.getCount() > 0) {

                    if (recyclerView.getVisibility() == View.VISIBLE) {
                        recyclerView.setVisibility(View.GONE);
                    }

                    cursor.moveToFirst();

                    final String propertyId = cursor.getString(cursor.getColumnIndexOrThrow(PropertyColumns.PROPERTYUNIQUEID));

                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            showTaxDetails(propertyId);
                        }
                    });
                }

                if (null == resultsCursorAdapter) {
                    resultsCursorAdapter = new ResultsCursorAdapter(cursor);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(resultsCursorAdapter);
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
    public void setTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }

    private void findViewByIDs() {

        setToolbar((Toolbar) findViewById(R.id.toolbar));

        setTitle("Last Synced: " + SharedPrefeHelper.getLastSync(ResultsActivity.this));

        recyclerView = (RecyclerView) findViewById(R.id.expandable_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        resultsCursorAdapter = new ResultsCursorAdapter(null);

        recyclerView.setAdapter(resultsCursorAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showTaxDetails(view.getTag().toString());
            }
        }));
    }

    private void showTaxDetails(String propertyId) {

        PlaceHolderFragment fragment = (PlaceHolderFragment) getSupportFragmentManager().findFragmentById(R.id.frame_results);

        if (null == fragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                    .add(R.id.frame_results, PlaceHolderFragment.getInstance(propertyId),
                            PlaceHolderFragment.TAG)
                    .addToBackStack(PlaceHolderFragment.TAG)
                    .commit();
        } else {
            replaceFragmentWithAnimation(PlaceHolderFragment.getInstance(propertyId), PlaceHolderFragment.TAG);
        }
    }

    public void replaceFragmentWithAnimation(android.support.v4.app.Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        transaction.replace(R.id.frame_results, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1)
            getSupportFragmentManager().popBackStack();

        if (null != resultsCursorAdapter && resultsCursorAdapter.getItemCount() == 1) {
            finish();
        }

        super.onBackPressed();
    }


    public static class PlaceHolderFragment extends Fragment {

        public static final String TAG = PlaceHolderFragment.class.getSimpleName();

        public static final String PLACEHOLDER_KEY = "key-property";

        public PlaceHolderFragment() {
        }

        public static PlaceHolderFragment getInstance(String property) {
            PlaceHolderFragment fragment = new PlaceHolderFragment();
            Bundle args = new Bundle();
            args.putString(PLACEHOLDER_KEY, property);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.layout_fragment_result, container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            initViews(view);

            view.findViewById(R.id.et_back_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });

            view.findViewById(R.id.et_pay_buttom).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), PaymentActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(INTENT_PARAMETERS._PREFILL_PROPERTYID, getArguments().getString(PLACEHOLDER_KEY));
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                }
            });

        }

        private void initViews(View view) {
            addChildViews(view);
        }

        private void addChildViews(final View view) {

            PropertySelection selection = new PropertySelection();

            selection.propertyuniqueid(getArguments().getString(PLACEHOLDER_KEY));

            PropertyCursor propertyCursor = selection.query(getActivity().getContentResolver());

            propertyCursor.moveToFirst();

            LinearLayout parent = (LinearLayout) view.findViewById(R.id.linear_parent_tax_detail);

            int paddingLeft = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
            int paddingRight = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
            int paddingTop = (int) getResources().getDimension(R.dimen.activity_vertical_margin);
            int paddingBottom = (int) getResources().getDimension(R.dimen.activity_vertical_margin);

            parent.setPadding(0, paddingTop, 0, paddingBottom);

            if (propertyCursor.getCount() > 0)
                for (int i = 1; i < propertyCursor.getColumnCount(); i++) {
                    TextView tv_taxdetail = new TextView(getActivity());
                    tv_taxdetail.setAllCaps(true);
                    tv_taxdetail.setTypeface(Typeface.MONOSPACE);
                    tv_taxdetail.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    tv_taxdetail.setText(String.format(Locale.getDefault(), "%-22s : %s", propertyCursor.getColumnName(i), propertyCursor.getString(propertyCursor.getColumnIndexOrThrow(propertyCursor.getColumnName(i)))));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tv_taxdetail.getLayoutParams();
                    layoutParams.leftMargin = paddingLeft;
                    layoutParams.rightMargin = paddingRight;
                    layoutParams.bottomMargin = paddingBottom;
                    tv_taxdetail.setLayoutParams(layoutParams);
                    parent.addView(tv_taxdetail);
                }

            propertyCursor.close();

            RelativeLayout relativeChild = new RelativeLayout(getActivity());
            relativeChild.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            relativeChild.setBackgroundColor(getResources().getColor(R.color.gray));
            ((LinearLayout.LayoutParams) relativeChild.getLayoutParams()).gravity = Gravity.CENTER_VERTICAL;
            ((LinearLayout.LayoutParams) relativeChild.getLayoutParams()).bottomMargin = paddingBottom;

            TextView taxDetailHeader = new TextView(getActivity());
            taxDetailHeader.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            RelativeLayout.LayoutParams taxDetailHeaderLayoutParams = (RelativeLayout.LayoutParams) taxDetailHeader.getLayoutParams();
            taxDetailHeaderLayoutParams.leftMargin = paddingLeft;
            taxDetailHeaderLayoutParams.rightMargin = paddingRight;
            taxDetailHeaderLayoutParams.bottomMargin = paddingBottom;
            taxDetailHeaderLayoutParams.topMargin = paddingTop;
            taxDetailHeaderLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            taxDetailHeader.setLayoutParams(taxDetailHeaderLayoutParams);
            taxDetailHeader.setTextColor(getResources().getColor(R.color.dark_gray));
            taxDetailHeader.setText("Tax Details(Rs)");

            final ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            RelativeLayout.LayoutParams paramsImageView = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            paramsImageView.leftMargin = paddingLeft;
            paramsImageView.rightMargin = paddingRight;
            paramsImageView.bottomMargin = paddingBottom;
            paramsImageView.topMargin = paddingTop;
            paramsImageView.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            imageView.setLayoutParams(paramsImageView);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_circle_outline));

            final LinearLayout linearChild = new LinearLayout(getActivity());
            linearChild.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            linearChild.setOrientation(LinearLayout.VERTICAL);
            linearChild.setVisibility(View.GONE);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (linearChild.getVisibility() == View.GONE) {
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_remove_circle_outline));
                        linearChild.setVisibility(View.VISIBLE);

                        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.parent_scrollview);
                        final int diff = scrollView.getHeight() - scrollView.getScrollY();

                        scrollView.post(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.scrollTo(0, diff);
                            }
                        });

                    } else {
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_circle_outline));
                        linearChild.setVisibility(View.GONE);
                    }
                }
            });

            TaxdetailSelection taxdetailSelection = new TaxdetailSelection();

            taxdetailSelection.propertyid(getArguments().getString(PLACEHOLDER_KEY));

            TaxdetailCursor taxdetailCursor = taxdetailSelection.query(getActivity().getContentResolver());

            taxdetailCursor.moveToFirst();

            if (taxdetailCursor.getCount() > 0)

                for (int i = 1; i < taxdetailCursor.getColumnCount(); i++) {
                    TextView tv_taxdetail = new TextView(getActivity());
                    tv_taxdetail.setTypeface(Typeface.MONOSPACE);
                    tv_taxdetail.setAllCaps(true);
                    tv_taxdetail.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                    if (taxdetailCursor.getColumnName(i).equalsIgnoreCase(TaxdetailColumns.DUEDATE))
                        tv_taxdetail.setText(String.format(Locale.getDefault(), "%-22s : %s", taxdetailCursor.getColumnName(i), DateTimeUtils.getFormattedDatefromLong(Long.parseLong(taxdetailCursor.getString(taxdetailCursor.getColumnIndexOrThrow(taxdetailCursor.getColumnName(i)))))));
                    else
                        tv_taxdetail.setText(String.format(Locale.getDefault(), "%-22s : %s", taxdetailCursor.getColumnName(i), taxdetailCursor.getString(taxdetailCursor.getColumnIndexOrThrow(taxdetailCursor.getColumnName(i)))));
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tv_taxdetail.getLayoutParams();
                    params.leftMargin = paddingLeft;
                    params.rightMargin = paddingRight;
                    params.bottomMargin = paddingBottom;
                    tv_taxdetail.setLayoutParams(params);
                    linearChild.addView(tv_taxdetail);
                }

            taxdetailCursor.close();

            relativeChild.addView(taxDetailHeader);
            relativeChild.addView(imageView);

            parent.addView(relativeChild);
            parent.addView(linearChild);
        }
    }
}
