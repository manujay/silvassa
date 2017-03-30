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
     * propertyUniqueId.
     */
    public static final String PROPERTYUNIQUEID = "propertyUniqueId";

    /**
     * taxNo
     */
    public static final String TAXNO = "taxNo";

    /**
     * mode
     */
    public static final String MODE = "mode";

    /**
     * payableAmount
     */
    public static final String PAYABLEAMOUNT = "payableAmount";

    /**
     * Amount
     */
    public static final String AMOUNT = "Amount";

    /**
     * Cheuque
     */
    public static final String CHEUQUE = "Cheuque";

    /**
     * DD
     */
    public static final String DD = "DD";

    /**
     * POS
     */
    public static final String POS = "POS";

    /**
     * email
     */
    public static final String EMAIL = "email";

    /**
     * phone
     */
    public static final String PHONE = "phone";

    /**
     * PaymentDate
     */
    public static final String PDATE = "Pdate";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            PROPERTYUNIQUEID,
            TAXNO,
            MODE,
            PAYABLEAMOUNT,
            AMOUNT,
            CHEUQUE,
            DD,
            POS,
            EMAIL,
            PHONE,
            PDATE
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(PROPERTYUNIQUEID) || c.contains("." + PROPERTYUNIQUEID)) return true;
            if (c.equals(TAXNO) || c.contains("." + TAXNO)) return true;
            if (c.equals(MODE) || c.contains("." + MODE)) return true;
            if (c.equals(PAYABLEAMOUNT) || c.contains("." + PAYABLEAMOUNT)) return true;
            if (c.equals(AMOUNT) || c.contains("." + AMOUNT)) return true;
            if (c.equals(CHEUQUE) || c.contains("." + CHEUQUE)) return true;
            if (c.equals(DD) || c.contains("." + DD)) return true;
            if (c.equals(POS) || c.contains("." + POS)) return true;
            if (c.equals(EMAIL) || c.contains("." + EMAIL)) return true;
            if (c.equals(PHONE) || c.contains("." + PHONE)) return true;
            if (c.equals(PDATE) || c.contains("." + PDATE)) return true;
        }
        return false;
    }

}
