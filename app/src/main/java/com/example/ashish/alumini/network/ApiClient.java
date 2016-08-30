package com.example.ashish.alumini.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashish on 8/8/16.
 */
public class ApiClient {

//    public static final String BASE_URL = "http://192.168.43.0:3000/";
//    public static final String BASE_URL = "http://192.168.43.115:3000/"; // mobile hotspot
//    public static final String BASE_URL = "http://192.168.42.22:3000/"; // usb tethring
//    public static final String BASE_URL = "http://192.168.137.152:3000/";
    public static final String BASE_URL = "http://172.16.1.238:3000/"; // bangon
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ServerApi getServerApi() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ServerApi.class);
    }


}