package com.mapmyindia.ceinfo.silvassa.restcontroller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapmyindia.ceinfo.silvassa.utils.APIUrls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ceinfo on 16-03-2017.
 */

public class RestAppController {

    private static HttpLoggingInterceptor loggingInterceptor;
    private static OkHttpClient okHttpClient;
    private static Gson gson;
    private static Retrofit retrofit;

    public static Retrofit getRetrofitinstance() {
        if (null == retrofit) {
            loggingInterceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
                    .setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor).build();
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(APIUrls.getBaseUrl())
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
