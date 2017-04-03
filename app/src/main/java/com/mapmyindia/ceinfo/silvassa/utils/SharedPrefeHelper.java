package com.mapmyindia.ceinfo.silvassa.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

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
        // use the ANDROID_ID constant, generated at the first device boot
        String deviceId = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        // in case known problems occur found in some chinese manufacturers
        if ("9774d56d682e549c".equals(deviceId) || deviceId == null) {

            // get a unique deviceID like IMEI for GSM or ESN for CDMA phones
            // don't forget:
            //
            deviceId = ((TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE))
                    .getDeviceId();

            // if nothing else works, generate a random number
            if (deviceId == null) {

                Random tmpRand = new Random();
                deviceId = String.valueOf(tmpRand.nextLong());
            }
        }

        // any value is hashed to have consistent format
        return getHash(deviceId);
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

    // generates a SHA-1 hash for any string
    public static String getHash(String stringToHash) {

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] result = null;

        try {
            result = digest.digest(stringToHash.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        for (byte b : result) {
            sb.append(String.format("%02X", b));
        }

        String messageDigest = sb.toString();
        return messageDigest;
    }

    public static String getUserInfo(Context context) {
        return getDefaultPref(context).getString(PREFERENCE_USERINFO, "");
    }
}
