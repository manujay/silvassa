package com.mapmyindia.ceinfo.silvassa.provider.occupier;

// @formatter:off

import android.net.Uri;
import android.provider.BaseColumns;

import com.mapmyindia.ceinfo.silvassa.provider.SilvassaProvider;

/**
 * Occupier Table Schema
 */
@SuppressWarnings("unused")
public class OccupierColumns implements BaseColumns {
    public static final String TABLE_NAME = "occupier";
    public static final Uri CONTENT_URI = Uri.parse(SilvassaProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * OccupierName.
     */
    public static final String OCCUPIERNAME = "OccupierName";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            OCCUPIERNAME
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(OCCUPIERNAME) || c.contains("." + OCCUPIERNAME)) return true;
        }
        return false;
    }

}
