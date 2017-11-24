package com.android.bali.helpers;


import com.android.bali.models.Data;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by zaur on 22/11/2017.
 */

public interface RetrofitInterface {
    @GET ("/")
    Call<String> getStringData();

}
