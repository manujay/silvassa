package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.net.Uri;
import android.provider.BaseColumns;

import com.mapmyindia.ceinfo.silvassa.provider.SilvassaProvider;

/**
 * TaxDetail Table Schema
 */
@SuppressWarnings("unused")
public class TaxdetailColumns implements BaseColumns {
    public static final String TABLE_NAME = "taxdetail";
    public static final Uri CONTENT_URI = Uri.parse(SilvassaProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * taxNo.
     */
    public static final String TAXNO = "taxNo";

    /**
     * propertyId.
     */
    public static final String PROPERTYID = "propertyId";

    /**
     * financialYear.
     */
    public static final String FINANCIALYEAR = "financialYear";

    /**
     * propertyTax.
     */
    public static final String PROPERTYTAX = "propertyTax";

    /**
     * waterTax.
     */
    public static final String WATERTAX = "waterTax";

    /**
     * conservancyTax.
     */
    public static final String CONSERVANCYTAX = "conservancyTax";

    /**
     * waterSewerageCharge.
     */
    public static final String WATERSEWERAGECHARGE = "waterSewerageCharge";

    /**
     * waterMeterBillAmount.
     */
    public static final String WATERMETERBILLAMOUNT = "waterMeterBillAmount";

    /**
     * arrearAmount.
     */
    public static final String ARREARAMOUNT = "arrearAmount";

    /**
     * advancePaidAmount.
     */
    public static final String ADVANCEPAIDAMOUNT = "advancePaidAmount";

    /**
     * rebateAmount.
     */
    public static final String REBATEAMOUNT = "rebateAmount";

    /**
     * adjustmentAmount.
     */
    public static final String ADJUSTMENTAMOUNT = "adjustmentAmount";

    /**
     * totalPropertyTax.
     */
    public static final String TOTALPROPERTYTAX = "totalPropertyTax";

    /**
     * serviceTax.
     */
    public static final String SERVICETAX = "serviceTax";

    /**
     * otherTax.
     */
    public static final String OTHERTAX = "otherTax";

    /**
     * grandTotal.
     */
    public static final String GRANDTOTAL = "grandTotal";

    /**
     * delayPaymentCharges.
     */
    public static final String DELAYPAYMENTCHARGES = "delayPaymentCharges";

    /**
     * payableAmount.
     */
    public static final String PAYABLEAMOUNT = "payableAmount";

    /**
     * dueDate.
     */
    public static final String DUEDATE = "dueDate";

    /**
     * noticeGenerated.
     */
    public static final String NOTICEGENERATED = "noticeGenerated";

    /**
     * objectionStatus.
     */
    public static final String OBJECTIONSTATUS = "objectionStatus";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            TAXNO,
            PROPERTYID,
            FINANCIALYEAR,
            PROPERTYTAX,
            WATERTAX,
            CONSERVANCYTAX,
            WATERSEWERAGECHARGE,
            WATERMETERBILLAMOUNT,
            ARREARAMOUNT,
            ADVANCEPAIDAMOUNT,
            REBATEAMOUNT,
            ADJUSTMENTAMOUNT,
            TOTALPROPERTYTAX,
            SERVICETAX,
            OTHERTAX,
            GRANDTOTAL,
            DELAYPAYMENTCHARGES,
            PAYABLEAMOUNT,
            DUEDATE,
            NOTICEGENERATED,
            OBJECTIONSTATUS
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TAXNO) || c.contains("." + TAXNO)) return true;
            if (c.equals(PROPERTYID) || c.contains("." + PROPERTYID)) return true;
            if (c.equals(FINANCIALYEAR) || c.contains("." + FINANCIALYEAR)) return true;
            if (c.equals(PROPERTYTAX) || c.contains("." + PROPERTYTAX)) return true;
            if (c.equals(WATERTAX) || c.contains("." + WATERTAX)) return true;
            if (c.equals(CONSERVANCYTAX) || c.contains("." + CONSERVANCYTAX)) return true;
            if (c.equals(WATERSEWERAGECHARGE) || c.contains("." + WATERSEWERAGECHARGE)) return true;
            if (c.equals(WATERMETERBILLAMOUNT) || c.contains("." + WATERMETERBILLAMOUNT))
                return true;
            if (c.equals(ARREARAMOUNT) || c.contains("." + ARREARAMOUNT)) return true;
            if (c.equals(ADVANCEPAIDAMOUNT) || c.contains("." + ADVANCEPAIDAMOUNT)) return true;
            if (c.equals(REBATEAMOUNT) || c.contains("." + REBATEAMOUNT)) return true;
            if (c.equals(ADJUSTMENTAMOUNT) || c.contains("." + ADJUSTMENTAMOUNT)) return true;
            if (c.equals(TOTALPROPERTYTAX) || c.contains("." + TOTALPROPERTYTAX)) return true;
            if (c.equals(SERVICETAX) || c.contains("." + SERVICETAX)) return true;
            if (c.equals(OTHERTAX) || c.contains("." + OTHERTAX)) return true;
            if (c.equals(GRANDTOTAL) || c.contains("." + GRANDTOTAL)) return true;
            if (c.equals(DELAYPAYMENTCHARGES) || c.contains("." + DELAYPAYMENTCHARGES)) return true;
            if (c.equals(PAYABLEAMOUNT) || c.contains("." + PAYABLEAMOUNT)) return true;
            if (c.equals(DUEDATE) || c.contains("." + DUEDATE)) return true;
            if (c.equals(NOTICEGENERATED) || c.contains("." + NOTICEGENERATED)) return true;
            if (c.equals(OBJECTIONSTATUS) || c.contains("." + OBJECTIONSTATUS)) return true;
        }
        return false;
    }

}
