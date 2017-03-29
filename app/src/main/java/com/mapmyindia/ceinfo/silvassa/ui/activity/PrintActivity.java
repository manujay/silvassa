package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailColumns;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailCursor;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailSelection;
import com.mapmyindia.ceinfo.silvassa.utils.DateTimeUtils;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;

import java.util.Locale;

/**
 * Created by ceinfo on 25-03-2017.
 */

public class PrintActivity extends BaseActivity {

    private static final String TAG = PrintActivity.class.getSimpleName();
    private String propertyId;
    private Toolbar mToolbar;

    @Override
    public void setTitle(String mTitle) {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_print_details);

        mToolbar = (Toolbar) findViewById(R.id.print_toolbar);

        setSupportActionBar(mToolbar);

        Bundle extras = getIntent().getExtras();

        if (null != extras && extras.containsKey(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
            propertyId = extras.getString(INTENT_PARAMETERS._PREFILL_PROPERTYID);
        }

        if (!StringUtils.isNullOrEmpty(propertyId)) {
            findViewByIDs();
        } else {
            ((TextView) findViewById(R.id.print_tv)).setTextColor(getResources().getColor(R.color.login_color));
            ((TextView) findViewById(R.id.print_tv)).setText(R.string.error_payment);
        }

    }

    private void findViewByIDs() {

        LinearLayout linear_parent = (LinearLayout) findViewById(R.id.print_wv);

        TaxdetailSelection selection = new TaxdetailSelection();
        selection.propertyid(propertyId);

        TaxdetailCursor taxdetailCursor = selection.query(getContentResolver());

        PropertySelection propertySelection = new PropertySelection();
        propertySelection.propertyuniqueid(propertyId);

        PropertyCursor propertyCursor = propertySelection.query(getContentResolver());

        if (propertyCursor.moveToFirst() && taxdetailCursor.moveToFirst()) {

            TextView textView0 = new TextView(this);
            textView0.setAllCaps(true);
            textView0.setTypeface(Typeface.MONOSPACE);
            textView0.setTextSize(12.0f);
            textView0.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            String propertyUniqueId = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYUNIQUEID) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYUNIQUEID);
            textView0.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYUNIQUEID, propertyUniqueId));

            TextView textView1 = new TextView(this);
            textView1.setAllCaps(true);
            textView1.setTypeface(Typeface.MONOSPACE);
            textView1.setTextSize(12.0f);
            textView1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            String propertyOwner = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOWNER) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOWNER);
            textView1.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYOWNER, propertyOwner));

            TextView textView2 = new TextView(this);
            textView2.setAllCaps(true);
            textView2.setTypeface(Typeface.MONOSPACE);
            textView2.setTextSize(12.0f);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            String dueDate = taxdetailCursor.getStringOrNull(TaxdetailColumns.DUEDATE) == null ? "0" : taxdetailCursor.getStringOrNull(TaxdetailColumns.DUEDATE);
            textView2.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.DUEDATE, DateTimeUtils.getFormattedDatefromLong(Long.parseLong(dueDate))));

            TextView textView3 = new TextView(this);
            textView3.setAllCaps(true);
            textView3.setTypeface(Typeface.MONOSPACE);
            textView3.setTextSize(12.0f);
            textView3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            String payableAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT);
            textView3.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.PAYABLEAMOUNT, payableAmount));

            TextView textView4 = new TextView(this);
            textView4.setAllCaps(true);
            textView4.setTypeface(Typeface.MONOSPACE);
            textView4.setTextSize(12.0f);
            textView4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            String phone = propertyCursor.getStringOrNull(PropertyColumns.PHONE) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PHONE);
            textView4.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PHONE, phone));

            TextView textView5 = new TextView(this);
            textView5.setAllCaps(true);
            textView5.setTypeface(Typeface.MONOSPACE);
            textView5.setTextSize(12.0f);
            textView5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            String email = propertyCursor.getStringOrNull(PropertyColumns.EMAIL) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.EMAIL);
            textView5.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.EMAIL, email));

            linear_parent.addView(textView0);
            linear_parent.addView(textView1);
            linear_parent.addView(textView2);
            linear_parent.addView(textView3);
            linear_parent.addView(textView4);
            linear_parent.addView(textView5);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.silvassa_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this, SyncSearchActivity.class);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
