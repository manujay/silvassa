package com.mapmyindia.ceinfo.silvassa.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ceinfo on 21-03-2017.
 */

public class SharedPrefeHelper {

    private static final String DEFAULT_PREF = "com.mapmyindia.ceinfo.silvassa";
    private static final String PREFRENCE_KEY_ZONE = "default-zone";
    private static SharedPreferences mDefaultPref;

    private static SharedPreferences getDefaultPref(Context context) {
        if (null == mDefaultPref)
            mDefaultPref = context.getSharedPreferences(DEFAULT_PREF, Context.MODE_PRIVATE);
        return mDefaultPref;
    }

    public static void setZoneId(Context context, String zoneId) {
        SharedPreferences pref = getDefaultPref(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PREFRENCE_KEY_ZONE, zoneId);
        editor.commit();
    }

    public static String getZoneId(Context context) {
        return getDefaultPref(context).getString(PREFRENCE_KEY_ZONE, "");
    }
}
