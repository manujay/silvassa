package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.net.Uri;
import android.provider.BaseColumns;

import com.mapmyindia.ceinfo.silvassa.provider.SilvassaProvider;

/**
 * Payment Table Schema
 */
@SuppressWarnings("unused")
public class PaymentColumns implements BaseColumns {
    public static final String TABLE_NAME = "payment";
    public static final Uri CONTENT_URI = Uri.parse(SilvassaProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * UserId.
     */
    public static final String USERID = "userId";

    /**
     * PropertyUniqueId.
     */
    public static final String PROPERTYUNIQUEID = "propertyUniqueId";

    /**
     * TaxNo.
     */
    public static final String TAXNO = "taxNo";

    /**
     * Mode
     */
    public static final String MODE = "mode";

    /**
     * Cheque
     */
    public static final String CHEQUE = "cheque";

    /**
     * Amount
     */
    public static final String AMOUNT = "Amount";

    /**
     * PaymentDate
     */
    public static final String PDATE = "Pdate";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            USERID,
            PROPERTYUNIQUEID,
            TAXNO,
            MODE,
            CHEQUE,
            AMOUNT,
            PDATE
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(USERID) || c.contains("." + USERID)) return true;
            if (c.equals(PROPERTYUNIQUEID) || c.contains("." + PROPERTYUNIQUEID)) return true;
            if (c.equals(TAXNO) || c.contains("." + TAXNO)) return true;
            if (c.equals(MODE) || c.contains("." + MODE)) return true;
            if (c.equals(CHEQUE) || c.contains("." + CHEQUE)) return true;
            if (c.equals(AMOUNT) || c.contains("." + AMOUNT)) return true;
            if (c.equals(PDATE) || c.contains("." + PDATE)) return true;
        }
        return false;
    }

}
