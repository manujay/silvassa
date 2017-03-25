package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailCursor;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailSelection;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;

/**
 * Created by ceinfo on 25-03-2017.
 */

public class PrintActivity extends BaseActivity {

    private static final String TAG = PrintActivity.class.getSimpleName();

    @Override
    public void setTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_print_details);

        Bundle extras = getIntent().getExtras();

        if (null != extras && extras.containsKey(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
            String propertyId = extras.getString(INTENT_PARAMETERS._PREFILL_PROPERTYID);

            TaxdetailSelection selection = new TaxdetailSelection();
            selection.propertyid(propertyId);

            TaxdetailCursor cursor = selection.query(getContentResolver());

            PropertySelection propertySelection = new PropertySelection();
            propertySelection.propertyuniqueid(propertyId);

            PropertyCursor propertyCursor = propertySelection.query(getContentResolver());

            if (propertyCursor.moveToFirst() && cursor.moveToFirst()) {

                StringBuilder builder = new StringBuilder();

                builder.append("<tr><td>PropertyID<span style=\"display:inline-block; width: 22;\">:</span></td><td>").append(propertyCursor.getPropertyuniqueid()).append("</td></tr></br>");
                builder.append("<tr><td>Owner Name<span style=\"display:inline-block; width: 22;\">:</span></td><td>").append(propertyCursor.getPropertyowner()).append("</td></tr></br>");
                builder.append("<tr><td>Date<span style=\"display:inline-block; width: 22;\">:</span></td><td>").append(cursor.getDuedate()).append("</td></tr></br>");
                builder.append("<tr><td>Amount<span style=\"display:inline-block; width: 22;\">:</span></td><td>").append(cursor.getAdjustmentamount()).append("</td></tr></br>");
                builder.append("<tr><td>Phone No<span style=\"display:inline-block; width: 22;\">:</span></td><td>").append(propertyCursor.getPhone()).append("</td></tr></br>");

                writeToWebView(builder.toString());
            }

            cursor.close();
            propertyCursor.close();
        }

        findViewByIDs();

    }

    private void writeToWebView(String s) {
        ((TextView) findViewById(R.id.print_wv)).setTypeface(Typeface.MONOSPACE);
        ((TextView) findViewById(R.id.print_wv)).setText(Html.fromHtml(s));

    }

    private void findViewByIDs() {
        setToolbar(((Toolbar) findViewById(R.id.toolbar)));

        setTitle(getString(R.string.app_name));
    }
}
