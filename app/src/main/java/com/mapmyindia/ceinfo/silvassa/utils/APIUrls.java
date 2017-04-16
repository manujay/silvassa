package com.mapmyindia.ceinfo.silvassa.utils;

import com.mapmyindia.ceinfo.silvassa.BuildConfig;

/**
 * Created by ceinfo on 13-04-2017.
 */

public class APIUrls {

    private static final String PRODUCTION_URL = "http://182.71.127.238:8080/SilvassaMob/";
    private static final String DEVELOPMENT_URL = "http://10.10.21.14:8080/SilvassaMob/";


    public static String getBaseUrl() {
        if (BuildConfig.DEBUG)
            return DEVELOPMENT_URL;
        else
            return PRODUCTION_URL;
    }
}
