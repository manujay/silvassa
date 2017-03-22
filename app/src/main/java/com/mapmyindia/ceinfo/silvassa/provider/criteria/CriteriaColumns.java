package com.mapmyindia.ceinfo.silvassa.provider.criteria;

// @formatter:off

import android.net.Uri;
import android.provider.BaseColumns;

import com.mapmyindia.ceinfo.silvassa.provider.SilvassaProvider;

/**
 * Criteria Table Schema
 */
@SuppressWarnings("unused")
public class CriteriaColumns implements BaseColumns {
    public static final String TABLE_NAME = "criteria";
    public static final Uri CONTENT_URI = Uri.parse(SilvassaProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * occupierName.
     */
    public static final String OCCUPIERNAME = "occupierName";

    /**
     * propId
     */
    public static final String PROPID = "propId";

    /**
     * ownerName
     */
    public static final String OWNERNAME = "ownerName";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            OCCUPIERNAME,
            PROPID,
            OWNERNAME
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(OCCUPIERNAME) || c.contains("." + OCCUPIERNAME)) return true;
            if (c.equals(PROPID) || c.contains("." + PROPID)) return true;
            if (c.equals(OWNERNAME) || c.contains("." + OWNERNAME)) return true;
        }
        return false;
    }

}
