package com.mapmyindia.ceinfo.silvassa.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

/**
 * Created by ceinfo on 21-03-2017.
 */

public class SharedPrefeHelper {

    private static final String DEFAULT_PREF = "com.mapmyindia.ceinfo.silvassa";
    private static final String PREFERENCE_KEY_ZONE = "default-zone";
    private static final String PREFERENCE_LAST_SYNC = "last-sync";
    private static final String PREFERENCE_USERID = "user-userId";
    private static final String PREFERENCE_USERINFO = "user-info";
    private static SharedPreferences mDefaultPref;

    private static SharedPreferences getDefaultPref(Context context) {
        if (null == mDefaultPref)
            mDefaultPref = context.getSharedPreferences(DEFAULT_PREF, Context.MODE_PRIVATE);
        return mDefaultPref;
    }

    public static void setZoneId(Context context, String zoneId) {
        SharedPreferences pref = getDefaultPref(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PREFERENCE_KEY_ZONE, zoneId);
        editor.commit();
    }

    public static String getZoneId(Context context) {
        return getDefaultPref(context).getString(PREFERENCE_KEY_ZONE, "");
    }

    public static String getLastSync(Context context) {
        return getDefaultPref(context).getString(PREFERENCE_LAST_SYNC, "");
    }

    public static void setLastSync(Context context, String lastSync) {
        SharedPreferences pref = getDefaultPref(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PREFERENCE_LAST_SYNC, lastSync);
        editor.commit();
    }

    public static String getDeviceId(Context context) {
        String uuid = "";
        try {
            uuid = Long.toString(Settings.Secure.getLong(context.getContentResolver(), Settings.Secure.ANDROID_ID));
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return uuid;
    }

    public static void setUserInfo(Context context, String json) {
        SharedPreferences pref = getDefaultPref(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PREFERENCE_USERINFO, json);
        editor.commit();
    }

    public static String getUserId(Context mContext) {
        return getDefaultPref(mContext).getString(PREFERENCE_USERID, "");
    }

    public static void setUserId(Context context, String userId) {
        SharedPreferences pref = getDefaultPref(context);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(PREFERENCE_USERID, userId);
        edit.commit();
    }
}
