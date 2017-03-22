package com.mapmyindia.ceinfo.silvassa.provider.owner;

// @formatter:off

import android.net.Uri;
import android.provider.BaseColumns;

import com.mapmyindia.ceinfo.silvassa.provider.SilvassaProvider;

/**
 * Owner Table Schema
 */
@SuppressWarnings("unused")
public class OwnerColumns implements BaseColumns {
    public static final String TABLE_NAME = "owner";
    public static final Uri CONTENT_URI = Uri.parse(SilvassaProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * OwnerName.
     */
    public static final String OWNERNAME = "OwnerName";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            OWNERNAME
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(OWNERNAME) || c.contains("." + OWNERNAME)) return true;
        }
        return false;
    }

}
