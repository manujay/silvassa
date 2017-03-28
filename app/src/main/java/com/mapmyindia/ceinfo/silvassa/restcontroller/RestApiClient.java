package com.mapmyindia.ceinfo.silvassa.restcontroller;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ceinfo on 17-03-2017.
 */

public interface RestApiClient {
    String BASE_URL = "http://182.71.127.238:8080/SilvassaMob/";
    String DEBUG_URL = "http://10.10.21.14:8080/SilvassaMob/";

    @GET("getZone")
    Call<ResponseBody> getZone();

    @GET("getSearchCriteria")
    Call<ResponseBody> getSearchCriteria(@Query("zoneId") String zoneId);

    @GET("searchProperty")
    Call<ResponseBody> searchProperty(@Query("searchBean") String data);
}
