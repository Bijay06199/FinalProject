package com.newsproj.newsproject.api;

import com.newsproj.newsproject.Model.DataValue;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by delaroy on 5/18/17.
 */
public interface Service {
//    api/schooldata/NewsAnnouncements?$top=1&$skip=0
    @GET("api/schooldata/NewsAnnouncements")
    Call<DataValue> getstudentsresponse(@Query("$top") int topId, @Query("$skip") int skipId);
}
