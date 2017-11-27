package com.android.bali.helpers;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public interface WeatherInterface {
    @GET("v1/public/yql/")
    Call<String> getWeather(@Query("q") String query, @Query("format") String format);
}
