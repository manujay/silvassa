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
     * taxAmount.
     */
    public static final String TAXAMOUNT = "taxAmount";

    /**
     * dueDate.
     */
    public static final String DUEDATE = "dueDate";

    /**
     * noticeGenerated.
     */
    public static final String NOTICEGENERATED = "noticeGenerated";

    /**
     * propId.
     */
    public static final String PROPID = "propId";

    /**
     * financialYear.
     */
    public static final String FINANCIALYEAR = "financialYear";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            TAXNO,
            TAXAMOUNT,
            DUEDATE,
            NOTICEGENERATED,
            PROPID,
            FINANCIALYEAR
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TAXNO) || c.contains("." + TAXNO)) return true;
            if (c.equals(TAXAMOUNT) || c.contains("." + TAXAMOUNT)) return true;
            if (c.equals(DUEDATE) || c.contains("." + DUEDATE)) return true;
            if (c.equals(NOTICEGENERATED) || c.contains("." + NOTICEGENERATED)) return true;
            if (c.equals(PROPID) || c.contains("." + PROPID)) return true;
            if (c.equals(FINANCIALYEAR) || c.contains("." + FINANCIALYEAR)) return true;
        }
        return false;
    }

}
