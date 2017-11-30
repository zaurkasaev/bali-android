package com.android.bali.helpers;

import com.android.bali.models.convertor.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public interface ConverterInterface {
    @GET("/latest")
    Call<Data> getData(@Query("base") String base);

}
