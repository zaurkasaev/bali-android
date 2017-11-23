package com.android.bali;

import android.app.Application;

import com.android.bali.helpers.RetrofitInterface;
import com.android.bali.helpers.XStreamHelper;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by zaur_ on 17.11.2017.
 */

public class App extends Application {
    XStreamHelper xStreamHelper;

    private Retrofit retrofit;

    private static RetrofitInterface retrofitInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://bali.new127.ru")
                .addConverterFactory(/*SimpleXmlConverterFactory.createNonStrict()*/ScalarsConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        xStreamHelper = new XStreamHelper(getApplicationContext());
    }

    public XStreamHelper getxStreamHelper() {
        return xStreamHelper;
    }

    public static RetrofitInterface getApi(){
        return  retrofitInterface;
    }
}
