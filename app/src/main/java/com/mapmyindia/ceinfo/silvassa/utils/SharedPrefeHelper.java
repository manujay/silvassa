package com.mapmyindia.ceinfo.silvassa.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

import com.mapmyindia.ceinfo.silvassa.ui.activity.LoginActivity;

/**
 * Created by ceinfo on 21-03-2017.
 */

public class SharedPrefeHelper {

    private static final String DEFAULT_PREF = "com.mapmyindia.ceinfo.silvassa";
    private static final String PREFERENCE_KEY_ZONE = "default-zone";
    private static final String PREFERENCE_LAST_SYNC = "last-sync";
    private static final String PREFERENCE_UUID = "user-deviceId";
    private static final String PREFERENCE_USERID = "user-userId";
    private static final String PREFERENCE_PASSWORD = "user-password";
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

    public static String getUUID(Context context) {
        String uuid = "";
        try {
            uuid = Long.toString(Settings.Secure.getLong(context.getContentResolver(), Settings.Secure.ANDROID_ID));
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return uuid;
    }

    public static void setUserInfo(Context context, LoginActivity.UserModel userModel) {
        SharedPreferences pref = getDefaultPref(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PREFERENCE_UUID, SharedPrefeHelper.getUUID(context));
        editor.putString(PREFERENCE_USERID, userModel.getUserName());
        editor.putString(PREFERENCE_PASSWORD, userModel.getPassword());
        editor.commit();
    }
}
