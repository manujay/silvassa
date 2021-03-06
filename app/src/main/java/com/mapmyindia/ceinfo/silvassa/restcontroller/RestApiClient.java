package com.mapmyindia.ceinfo.silvassa.restcontroller;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ceinfo on 17-03-2017.
 */

public interface RestApiClient {

    @GET("mobLogin")
    Call<ResponseBody> mobLogin(@Query("loginBean") String loginBean);

    @GET("getZone")
    Call<ResponseBody> getZone();

    @GET("getSearchCriteria")
    Call<ResponseBody> getSearchCriteria(@Query("zoneId") String zoneId);

    @GET("searchProperty")
    Call<ResponseBody> searchProperty(@Query("searchBean") String searchBean);

    @GET("mobPayment")
    Call<ResponseBody> mobPayment(@Query("paymentBean") String paymentBean);
}
