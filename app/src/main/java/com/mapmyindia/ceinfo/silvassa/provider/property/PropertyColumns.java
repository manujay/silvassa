package com.mapmyindia.ceinfo.silvassa.provider.property;

// @formatter:off

import android.net.Uri;
import android.provider.BaseColumns;

import com.mapmyindia.ceinfo.silvassa.provider.SilvassaProvider;

/**
 * Property Table Schema
 */
@SuppressWarnings("unused")
public class PropertyColumns implements BaseColumns {
    public static final String TABLE_NAME = "property";
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
     * propertyOwner.
     */
    public static final String PROPERTYOWNER = "propertyOwner";

    /**
     * propertyOccupierName.
     */
    public static final String PROPERTYOCCUPIERNAME = "propertyOccupierName";

    /**
     * propertyRelationOwner.
     */
    public static final String PROPERTYRELATIONOWNER = "propertyRelationOwner";

    /**
     * zoneId.
     */
    public static final String ZONEID = "zoneId";

    /**
     * propertySublocality.
     */
    public static final String PROPERTYSUBLOCALITY = "propertySublocality";

    /**
     * email.
     */
    public static final String EMAIL = "email";

    /**
     * phone.
     */
    public static final String PHONE = "phone";

    /**
     * propertyLandmark.
     */
    public static final String PROPERTYLANDMARK = "propertyLandmark";

    /**
     * propertyPlotNo.
     */
    public static final String PROPERTYPLOTNO = "propertyPlotNo";

    /**
     * propertyHouseNo.
     */
    public static final String PROPERTYHOUSENO = "propertyHouseNo";

    /**
     * propertyRoad.
     */
    public static final String PROPERTYROAD = "propertyRoad";

    /**
     * propertyPincode.
     */
    public static final String PROPERTYPINCODE = "propertyPincode";

    /**
     * propertyBuildingName.
     */
    public static final String PROPERTYBUILDINGNAME = "propertyBuildingName";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[]{
            _ID,
            PROPERTYUNIQUEID,
            PROPERTYOWNER,
            PROPERTYOCCUPIERNAME,
            PROPERTYRELATIONOWNER,
            ZONEID,
            PROPERTYSUBLOCALITY,
            EMAIL,
            PHONE,
            PROPERTYLANDMARK,
            PROPERTYPLOTNO,
            PROPERTYHOUSENO,
            PROPERTYROAD,
            PROPERTYPINCODE,
            PROPERTYBUILDINGNAME
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(PROPERTYUNIQUEID) || c.contains("." + PROPERTYUNIQUEID)) return true;
            if (c.equals(PROPERTYOWNER) || c.contains("." + PROPERTYOWNER)) return true;
            if (c.equals(PROPERTYOCCUPIERNAME) || c.contains("." + PROPERTYOCCUPIERNAME))
                return true;
            if (c.equals(PROPERTYRELATIONOWNER) || c.contains("." + PROPERTYRELATIONOWNER))
                return true;
            if (c.equals(ZONEID) || c.contains("." + ZONEID)) return true;
            if (c.equals(PROPERTYSUBLOCALITY) || c.contains("." + PROPERTYSUBLOCALITY)) return true;
            if (c.equals(EMAIL) || c.contains("." + EMAIL)) return true;
            if (c.equals(PHONE) || c.contains("." + PHONE)) return true;
            if (c.equals(PROPERTYLANDMARK) || c.contains("." + PROPERTYLANDMARK)) return true;
            if (c.equals(PROPERTYPLOTNO) || c.contains("." + PROPERTYPLOTNO)) return true;
            if (c.equals(PROPERTYHOUSENO) || c.contains("." + PROPERTYHOUSENO)) return true;
            if (c.equals(PROPERTYROAD) || c.contains("." + PROPERTYROAD)) return true;
            if (c.equals(PROPERTYPINCODE) || c.contains("." + PROPERTYPINCODE)) return true;
            if (c.equals(PROPERTYBUILDINGNAME) || c.contains("." + PROPERTYBUILDINGNAME))
                return true;
        }
        return false;
    }

}
