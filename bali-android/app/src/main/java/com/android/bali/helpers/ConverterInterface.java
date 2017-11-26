package com.android.bali.helpers;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public interface ConverterInterface {
    @GET("/daily.xml")
    Call<String> getStringData();
}
