package com.mapmyindia.ceinfo.silvassa.provider.zone;

// @formatter:off

import android.net.Uri;
import android.provider.BaseColumns;

import com.mapmyindia.ceinfo.silvassa.provider.SilvassaProvider;

/**
 * Zone Table Schema
 */
@SuppressWarnings("unused")
public class ZoneColumns implements BaseColumns {
    public static final String TABLE_NAME = "zone";
    public static final Uri CONTENT_URI = Uri.parse(SilvassaProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * zoneId.
     */
    public static final String ZONEID = "zoneId";

    /**
     * zoneName
     */
    public static final String ZONENAME = "zoneName";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            ZONEID,
            ZONENAME
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(ZONEID) || c.contains("." + ZONEID)) return true;
            if (c.equals(ZONENAME) || c.contains("." + ZONENAME)) return true;
        }
        return false;
    }

}
