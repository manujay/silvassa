package com.mapmyindia.ceinfo.silvassa.ui.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyColumns;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailColumns;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailCursor;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailSelection;
import com.mapmyindia.ceinfo.silvassa.ui.activity.PaymentActivity;
import com.mapmyindia.ceinfo.silvassa.utils.DateTimeUtils;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;

import java.util.Locale;

/**
 * Created by ceinfo on 29-03-2017.
 */
public class PlaceHolderFragment extends Fragment {

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

        LinearLayout parent = (LinearLayout) view.findViewById(R.id.linear_parent_tax_detail);

        int paddingLeft = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
        int paddingRight = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
        int paddingTop = (int) getResources().getDimension(R.dimen.activity_vertical_margin);
        int paddingBottom = (int) getResources().getDimension(R.dimen.activity_vertical_margin);

        parent.setPadding(0, paddingTop, 0, paddingBottom);

        LinearLayout.LayoutParams tv_params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tv_params.leftMargin = paddingLeft;
        tv_params.rightMargin = paddingRight;
        tv_params.bottomMargin = paddingBottom;

        if (propertyCursor.moveToFirst()) {
            TextView tv_property0 = new TextView(getActivity());
            tv_property0.setAllCaps(true);
            tv_property0.setTypeface(Typeface.MONOSPACE);
            tv_property0.setLayoutParams(tv_params);
            String propertyUniqueId = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYUNIQUEID) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYUNIQUEID);
            tv_property0.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYUNIQUEID, propertyUniqueId));
            parent.addView(tv_property0);

            TextView tv_property1 = new TextView(getActivity());
            tv_property1.setAllCaps(true);
            tv_property1.setTypeface(Typeface.MONOSPACE);
            tv_property1.setLayoutParams(tv_params);
            String propertyOwner = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOWNER) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOWNER);
            tv_property1.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYOWNER, propertyOwner));
            parent.addView(tv_property1);

            TextView tv_property2 = new TextView(getActivity());
            tv_property2.setAllCaps(true);
            tv_property2.setTypeface(Typeface.MONOSPACE);
            tv_property2.setLayoutParams(tv_params);
            String propertyOccupierName = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOCCUPIERNAME) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYOCCUPIERNAME);
            tv_property2.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYOCCUPIERNAME, propertyOccupierName));
            parent.addView(tv_property2);

            TextView tv_property3 = new TextView(getActivity());
            tv_property3.setAllCaps(true);
            tv_property3.setTypeface(Typeface.MONOSPACE);
            tv_property3.setLayoutParams(tv_params);
            String propertyRelationOwner = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYRELATIONOWNER) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYRELATIONOWNER);
            tv_property3.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYRELATIONOWNER, propertyRelationOwner));
            parent.addView(tv_property3);

            TextView tv_property4 = new TextView(getActivity());
            tv_property4.setAllCaps(true);
            tv_property4.setTypeface(Typeface.MONOSPACE);
            tv_property4.setLayoutParams(tv_params);
            String propertySublocality = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYSUBLOCALITY) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYSUBLOCALITY);
            tv_property4.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYSUBLOCALITY, propertySublocality));
            parent.addView(tv_property4);

            TextView tv_property5 = new TextView(getActivity());
            tv_property5.setAllCaps(true);
            tv_property5.setTypeface(Typeface.MONOSPACE);
            tv_property5.setLayoutParams(tv_params);
            String email = propertyCursor.getStringOrNull(PropertyColumns.EMAIL) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.EMAIL);
            tv_property5.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.EMAIL, email));
            parent.addView(tv_property5);

            TextView tv_property6 = new TextView(getActivity());
            tv_property6.setAllCaps(true);
            tv_property6.setTypeface(Typeface.MONOSPACE);
            tv_property6.setLayoutParams(tv_params);
            String phone = propertyCursor.getStringOrNull(PropertyColumns.PHONE) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PHONE);
            tv_property6.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PHONE, phone));
            parent.addView(tv_property6);

            TextView tv_property7 = new TextView(getActivity());
            tv_property7.setAllCaps(true);
            tv_property7.setTypeface(Typeface.MONOSPACE);
            tv_property7.setLayoutParams(tv_params);
            String propertyLandmark = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYLANDMARK) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYLANDMARK);
            tv_property7.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYLANDMARK, propertyLandmark));
            parent.addView(tv_property7);

            TextView tv_property8 = new TextView(getActivity());
            tv_property8.setAllCaps(true);
            tv_property8.setTypeface(Typeface.MONOSPACE);
            tv_property8.setLayoutParams(tv_params);
            String propertyPlotNo = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYPLOTNO) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYPLOTNO);
            tv_property8.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYPLOTNO, propertyPlotNo));
            parent.addView(tv_property8);

            TextView tv_property9 = new TextView(getActivity());
            tv_property9.setAllCaps(true);
            tv_property9.setTypeface(Typeface.MONOSPACE);
            tv_property9.setLayoutParams(tv_params);
            String propertyHouseNo = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYHOUSENO) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYHOUSENO);
            tv_property9.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYHOUSENO, propertyHouseNo));
            parent.addView(tv_property9);

            TextView tv_property10 = new TextView(getActivity());
            tv_property10.setAllCaps(true);
            tv_property10.setTypeface(Typeface.MONOSPACE);
            tv_property10.setLayoutParams(tv_params);
            String propertyRoad = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYROAD) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYROAD);
            tv_property10.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYROAD, propertyRoad));
            parent.addView(tv_property10);

            TextView tv_property11 = new TextView(getActivity());
            tv_property11.setAllCaps(true);
            tv_property11.setTypeface(Typeface.MONOSPACE);
            tv_property11.setLayoutParams(tv_params);
            String propertyPincode = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYPINCODE) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYPINCODE);
            tv_property11.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYPINCODE, propertyPincode));
            parent.addView(tv_property11);

            TextView tv_property12 = new TextView(getActivity());
            tv_property12.setAllCaps(true);
            tv_property12.setTypeface(Typeface.MONOSPACE);
            tv_property12.setLayoutParams(tv_params);
            String propertyBuildingName = propertyCursor.getStringOrNull(PropertyColumns.PROPERTYBUILDINGNAME) == null ? "" : propertyCursor.getStringOrNull(PropertyColumns.PROPERTYBUILDINGNAME);
            tv_property12.setText(String.format(Locale.getDefault(), "%-22s : %s", PropertyColumns.PROPERTYBUILDINGNAME, propertyBuildingName));
            parent.addView(tv_property12);
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
                    final int diff = (scrollView.getTop() + scrollView.getBottom()) / 2;

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

        if (taxdetailCursor.moveToFirst()) {

            TextView tv_taxdetail0 = new TextView(getActivity());
            tv_taxdetail0.setAllCaps(true);
            tv_taxdetail0.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail0.setLayoutParams(tv_params);
            String taxNo = taxdetailCursor.getStringOrNull(TaxdetailColumns.TAXNO) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.TAXNO);
            tv_taxdetail0.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.TAXNO, taxNo));
            linearChild.addView(tv_taxdetail0);

            TextView tv_taxdetail01 = new TextView(getActivity());
            tv_taxdetail01.setAllCaps(true);
            tv_taxdetail01.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail01.setLayoutParams(tv_params);
            String financialYear = taxdetailCursor.getStringOrNull(TaxdetailColumns.FINANCIALYEAR) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.FINANCIALYEAR);
            tv_taxdetail01.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.FINANCIALYEAR, financialYear));
            linearChild.addView(tv_taxdetail01);

            TextView tv_taxdetail02 = new TextView(getActivity());
            tv_taxdetail02.setAllCaps(true);
            tv_taxdetail02.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail02.setLayoutParams(tv_params);
            String propertyTax = taxdetailCursor.getStringOrNull(TaxdetailColumns.PROPERTYTAX) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.PROPERTYTAX);
            tv_taxdetail02.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.PROPERTYTAX, propertyTax));
            linearChild.addView(tv_taxdetail02);

            TextView tv_taxdetail03 = new TextView(getActivity());
            tv_taxdetail03.setAllCaps(true);
            tv_taxdetail03.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail03.setLayoutParams(tv_params);
            String waterTax = taxdetailCursor.getStringOrNull(TaxdetailColumns.WATERTAX) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.WATERTAX);
            tv_taxdetail03.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.WATERTAX, waterTax));
            linearChild.addView(tv_taxdetail03);

            TextView tv_taxdetail04 = new TextView(getActivity());
            tv_taxdetail04.setAllCaps(true);
            tv_taxdetail04.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail04.setLayoutParams(tv_params);
            String conservancyTax = taxdetailCursor.getStringOrNull(TaxdetailColumns.CONSERVANCYTAX) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.CONSERVANCYTAX);
            tv_taxdetail04.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.CONSERVANCYTAX, conservancyTax));
            linearChild.addView(tv_taxdetail04);

            TextView tv_taxdetail05 = new TextView(getActivity());
            tv_taxdetail05.setAllCaps(true);
            tv_taxdetail05.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail05.setLayoutParams(tv_params);
            String waterSewerageCharge = taxdetailCursor.getStringOrNull(TaxdetailColumns.WATERSEWERAGECHARGE) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.WATERSEWERAGECHARGE);
            tv_taxdetail05.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.WATERSEWERAGECHARGE, waterSewerageCharge));
            linearChild.addView(tv_taxdetail05);

            TextView tv_taxdetail06 = new TextView(getActivity());
            tv_taxdetail06.setAllCaps(true);
            tv_taxdetail06.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail06.setLayoutParams(tv_params);
            String waterMeterBillAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.WATERMETERBILLAMOUNT) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.WATERMETERBILLAMOUNT);
            tv_taxdetail06.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.WATERMETERBILLAMOUNT, waterMeterBillAmount));
            linearChild.addView(tv_taxdetail06);

            TextView tv_taxdetail07 = new TextView(getActivity());
            tv_taxdetail07.setAllCaps(true);
            tv_taxdetail07.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail07.setLayoutParams(tv_params);
            String arrearAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.ARREARAMOUNT) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.ARREARAMOUNT);
            tv_taxdetail07.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.ARREARAMOUNT, arrearAmount));
            linearChild.addView(tv_taxdetail07);


            TextView tv_taxdetail08 = new TextView(getActivity());
            tv_taxdetail08.setAllCaps(true);
            tv_taxdetail08.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail08.setLayoutParams(tv_params);
            String advancePaidAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.ADVANCEPAIDAMOUNT) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.ADVANCEPAIDAMOUNT);
            tv_taxdetail08.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.ADVANCEPAIDAMOUNT, advancePaidAmount));
            linearChild.addView(tv_taxdetail08);

            TextView tv_taxdetail09 = new TextView(getActivity());
            tv_taxdetail09.setAllCaps(true);
            tv_taxdetail09.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail09.setLayoutParams(tv_params);
            String rebateAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.REBATEAMOUNT) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.REBATEAMOUNT);
            tv_taxdetail09.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.REBATEAMOUNT, rebateAmount));
            linearChild.addView(tv_taxdetail09);

            TextView tv_taxdetail10 = new TextView(getActivity());
            tv_taxdetail10.setAllCaps(true);
            tv_taxdetail10.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail10.setLayoutParams(tv_params);
            String adjustmentAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.ADJUSTMENTAMOUNT) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.ADJUSTMENTAMOUNT);
            tv_taxdetail10.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.ADJUSTMENTAMOUNT, adjustmentAmount));
            linearChild.addView(tv_taxdetail10);

            TextView tv_taxdetail11 = new TextView(getActivity());
            tv_taxdetail11.setAllCaps(true);
            tv_taxdetail11.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail11.setLayoutParams(tv_params);
            String totalPropertyTax = taxdetailCursor.getStringOrNull(TaxdetailColumns.TOTALPROPERTYTAX) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.TOTALPROPERTYTAX);
            tv_taxdetail11.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.TOTALPROPERTYTAX, totalPropertyTax));
            linearChild.addView(tv_taxdetail11);

            TextView tv_taxdetail12 = new TextView(getActivity());
            tv_taxdetail12.setAllCaps(true);
            tv_taxdetail12.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail12.setLayoutParams(tv_params);
            String serviceTax = taxdetailCursor.getStringOrNull(TaxdetailColumns.SERVICETAX) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.SERVICETAX);
            tv_taxdetail12.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.SERVICETAX, serviceTax));
            linearChild.addView(tv_taxdetail12);

            TextView tv_taxdetail13 = new TextView(getActivity());
            tv_taxdetail13.setAllCaps(true);
            tv_taxdetail13.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail13.setLayoutParams(tv_params);
            String otherTax = taxdetailCursor.getStringOrNull(TaxdetailColumns.OTHERTAX) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.OTHERTAX);
            tv_taxdetail13.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.OTHERTAX, otherTax));
            linearChild.addView(tv_taxdetail13);

            TextView tv_taxdetail14 = new TextView(getActivity());
            tv_taxdetail14.setAllCaps(true);
            tv_taxdetail14.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail14.setLayoutParams(tv_params);
            String grandTotal = taxdetailCursor.getStringOrNull(TaxdetailColumns.GRANDTOTAL) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.GRANDTOTAL);
            tv_taxdetail14.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.GRANDTOTAL, grandTotal));
            linearChild.addView(tv_taxdetail14);

            TextView tv_taxdetail15 = new TextView(getActivity());
            tv_taxdetail15.setAllCaps(true);
            tv_taxdetail15.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail15.setLayoutParams(tv_params);
            String delayPaymentCharges = taxdetailCursor.getStringOrNull(TaxdetailColumns.DELAYPAYMENTCHARGES) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.DELAYPAYMENTCHARGES);
            tv_taxdetail15.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.DELAYPAYMENTCHARGES, delayPaymentCharges));
            linearChild.addView(tv_taxdetail15);

            TextView tv_taxdetail16 = new TextView(getActivity());
            tv_taxdetail16.setAllCaps(true);
            tv_taxdetail16.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail16.setLayoutParams(tv_params);
            String payableAmount = taxdetailCursor.getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT);
            tv_taxdetail16.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.PAYABLEAMOUNT, payableAmount));
            linearChild.addView(tv_taxdetail16);

            TextView tv_taxdetail17 = new TextView(getActivity());
            tv_taxdetail17.setAllCaps(true);
            tv_taxdetail17.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail17.setLayoutParams(tv_params);
            String dueDate = taxdetailCursor.getStringOrNull(TaxdetailColumns.DUEDATE) == null ? "0" : taxdetailCursor.getStringOrNull(TaxdetailColumns.DUEDATE);
            tv_taxdetail17.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.DUEDATE, DateTimeUtils.getFormattedDatefromLong(Long.parseLong(dueDate))));
            linearChild.addView(tv_taxdetail17);

            TextView tv_taxdetail18 = new TextView(getActivity());
            tv_taxdetail18.setAllCaps(true);
            tv_taxdetail18.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail18.setLayoutParams(tv_params);
            String noticeGenerated = taxdetailCursor.getStringOrNull(TaxdetailColumns.NOTICEGENERATED) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.NOTICEGENERATED);
            tv_taxdetail18.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.NOTICEGENERATED, noticeGenerated));
            linearChild.addView(tv_taxdetail18);

            TextView tv_taxdetail19 = new TextView(getActivity());
            tv_taxdetail19.setAllCaps(true);
            tv_taxdetail19.setTypeface(Typeface.MONOSPACE);
            tv_taxdetail19.setLayoutParams(tv_params);
            String objectionStatus = taxdetailCursor.getStringOrNull(TaxdetailColumns.OBJECTIONSTATUS) == null ? "" : taxdetailCursor.getStringOrNull(TaxdetailColumns.OBJECTIONSTATUS);
            tv_taxdetail19.setText(String.format(Locale.getDefault(), "%-22s : %s", TaxdetailColumns.OBJECTIONSTATUS, objectionStatus));
            linearChild.addView(tv_taxdetail19);

        }

        taxdetailCursor.close();

        relativeChild.addView(taxDetailHeader);
        relativeChild.addView(imageView);

        parent.addView(relativeChild);
        parent.addView(linearChild);
    }
}
