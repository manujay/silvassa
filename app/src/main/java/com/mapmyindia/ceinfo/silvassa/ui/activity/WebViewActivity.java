package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentColumns;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentCursor;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentSelection;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailColumns;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailCursor;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailSelection;
import com.mapmyindia.ceinfo.silvassa.utils.DateTimeUtils;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Locale;

/**
 * Created by ceinfo on 14/06/2017.
 */

public class WebViewActivity extends BaseActivity {

    private static final String TAG = WebViewActivity.class.getSimpleName();
    private WebView mWebView;
    private String propertyId;
    private long paymentId;

    public static Bitmap getBitmapFromView(View view) {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return bitmap;
    }

    @Override
    public void onActionCliked() {

    }

    @Override
    public void setmTitle(String mTitle) {
        ((TextView) getToolbar().findViewById(R.id.tv_toolbar)).setText(mTitle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();

        if (null != extras && extras.containsKey(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {
            propertyId = extras.getString(INTENT_PARAMETERS._PREFILL_PROPERTYID);
        }

        if (null != extras && extras.containsKey(INTENT_PARAMETERS._PREFILL_PAYMENTID)) {
            paymentId = extras.getLong(INTENT_PARAMETERS._PREFILL_PAYMENTID);
        }

        setContentView(R.layout.activity_webview);

        setToolbar((Toolbar) findViewById(R.id.toolbar));

        setSupportActionBar(getToolbar());

        setmTitle("");

        doWebViewPrint();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.print_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.close_print:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createWebBitmap(final WebView webView) {
        showToast(WebViewActivity.this, "Current Device does not support printing trying to create bitmap.");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                saveAsBitmap(webView);
            }
        }, 1000);
    }

    private void doWebViewPrint() {

        TaxdetailSelection selection = new TaxdetailSelection();
        selection.propertyid(propertyId);

        PropertySelection propertySelection = new PropertySelection();
        propertySelection.propertyuniqueid(propertyId);

        PaymentSelection paymentSelection = new PaymentSelection();
        paymentSelection.id(paymentId);

        TaxdetailCursor taxdetailCursor = selection.query(getContentResolver());

        PaymentCursor paymentCursor = paymentSelection.query(getContentResolver());

        PropertyCursor propertyCursor = propertySelection.query(getContentResolver());

        // Generate an HTML document on the fly:
        String htmlDocument = "";

        if (propertyCursor.moveToFirst() && taxdetailCursor.moveToFirst() && paymentCursor.moveToFirst()) {

            htmlDocument += "<html><style type=\"text/css\"> span { width: 160px; display: block; } table, th, td {\n" +
                    "   border: 1px solid black;\n" +
                    "}</style><body><h1><center>PAYMENT INVOICE</center></h1><p><center><table>" + "";

            String propertyUniqueId = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYUNIQUEID) == null ? "N/A" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYUNIQUEID);
            htmlDocument += "<tr><td><span>Property Id : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", propertyUniqueId) + "</span></td></tr>";

            String propertyOwner = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOWNER) == null ? "N/A" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOWNER);
            htmlDocument += "<tr><td><span>Owner : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", propertyOwner) + "</span></td></tr>";

            String dueDate = taxdetailCursor.getStringOrNull(TaxdetailColumns.DUEDATE) == null ? "0" : taxdetailCursor.getStringOrNull(TaxdetailColumns.DUEDATE);
            htmlDocument += "<tr><td><span>Due Date : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", DateTimeUtils.getFormattedDatefromLong(Long.parseLong(dueDate))) + "</span></td></tr>";

            String payableAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT) == null ? "N/A" : taxdetailCursor.getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT);
            htmlDocument += "<tr><td><span>Payable Amount (Rs) : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%.2f", Double.parseDouble(payableAmount)) + "</span></td></tr>";

            String Amount = paymentCursor.getStringOrNull(PaymentColumns.AMOUNT) == null ? "N/A" : paymentCursor.getStringOrNull(PaymentColumns.AMOUNT);
            htmlDocument += "<tr><td><span>Amount (Rs) : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%.2f", Double.parseDouble(Amount)) + "</span></td></tr>";

            String Pdate = paymentCursor.getStringOrNull(PaymentColumns.PDATE) == null ? "N/A" : paymentCursor.getStringOrNull(PaymentColumns.PDATE);
            htmlDocument += "<tr><td><span>Date of Payment : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", DateTimeUtils.getFormattedDatefromLong(Long.parseLong(Pdate))) + "</span></td></tr>";

            String Mode = paymentCursor.getStringOrNull(PaymentColumns.MODE) == null ? "N/A" : paymentCursor.getStringOrNull(PaymentColumns.MODE);
            htmlDocument += "<tr><td><span>Mode of Payment : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", Mode) + "</span></td></tr>";

            String taxNo = taxdetailCursor.getStringOrNull(TaxdetailColumns.TAXNO) == null ? "N/A" : taxdetailCursor.getStringOrNull(TaxdetailColumns.TAXNO);
            htmlDocument += "<tr><td><span>Tax Number : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", taxNo) + "</span></td></tr>";

            String phone = propertyCursor.getStringOrNull(PropertyColumns.PHONE) == null ? "N/A" : propertyCursor.getStringOrNull(PropertyColumns.PHONE);
            htmlDocument += "<tr><td><span>Phone : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", phone) + "</span></td></tr>";

            String email = propertyCursor.getStringOrNull(PropertyColumns.EMAIL) == null ? "N/A" : propertyCursor.getStringOrNull(PropertyColumns.EMAIL);
            htmlDocument += "<tr><td><span>Email : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", email) + "</span></td></tr>";

            String cheque = paymentCursor.getStringOrNull(PaymentColumns.CHEQUE) == null ? "N/A" : paymentCursor.getStringOrNull(PaymentColumns.CHEQUE);
            htmlDocument += "<tr><td><span>Cheque/DD : </span></td>";
            htmlDocument += "<td><span>" + String.format(Locale.getDefault(), "%s", cheque) + "</span></td></tr>";
        }

        htmlDocument += "</table></center></p></body></html>";

        // Create a WebView object specifically for printing
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                Log.d(TAG, " finished loading " + url);

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                    createWebBitmap(view);
                } else {
                    createWebPrintJob(view);
                }

                mWebView = null;
            }
        });

        webView.loadDataWithBaseURL(null, htmlDocument, "text/html", "UTF-8", null);

        paymentCursor.close();
        propertyCursor.close();
        taxdetailCursor.close();

        // Keep a reference to WebView object until you pass the PrintDocumentAdapter
        // to the PrintManager
        mWebView = webView;
    }

    private void saveAsBitmap(final WebView view) {
        Bitmap bitmap = getBitmapFromView(view);
        if (bitmap != null) {
            try {
                File parent = new File(Environment.getExternalStorageDirectory().toString(), getString(R.string.app_name));
                if (!parent.exists()) {
                    parent.mkdir();
                }
                OutputStream out = null;
                File file = new File(parent, "/webviewScreenShot_" + System.currentTimeMillis() + "_.png");
                if (!file.exists()) {
                    file.createNewFile();
                }
                out = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, out);
                out.flush();
                out.close();
                bitmap.recycle();

                showToast(WebViewActivity.this, "Saving Invoice as Bitmap with filename \n\r" + file.getName());

            } catch (Exception e) {
                e.printStackTrace();
                showToast(WebViewActivity.this, "Failure Saving Invoice as Bitmap.");
            }
        }
    }

    private void createWebPrintJob(WebView webView) {
        // Get a PrintManager instance
        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);

        // Get a print adapter instance
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();

        // Create a print job with name and adapter instance
        String jobName = getString(R.string.app_name) + " Document";
        PrintJob printJob = printManager.print(jobName, printAdapter,
                new PrintAttributes.Builder().build());

//        // Save the job object for later status checking
//        mPrintJobs.add(printJob);
    }
}