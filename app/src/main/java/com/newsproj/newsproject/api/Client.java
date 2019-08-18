package com.newsproj.newsproject.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by delaroy on 5/18/17.
 */
public class Client {
//    http://school3.yarshatech.com/api/schooldata/NewsAnnouncements?$top=1&$skip=0
    public static final String BASE_URL = "http://www.school3.yarshatech.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
