package com.android.bali;

import android.app.Application;

import com.android.bali.helpers.BaliDataInterface;
import com.android.bali.helpers.ConverterInterface;
import com.android.bali.helpers.WeatherInterface;
import com.android.bali.helpers.XStreamHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by zaur_ on 17.11.2017.
 */

public class App extends Application {
    XStreamHelper xStreamHelper;

    private Retrofit retrofit;
    private Retrofit retrofitWeather;
    private Retrofit converter;

    private static BaliDataInterface baliDataInterface;

    private static WeatherInterface weatherInterface;

    private static ConverterInterface converterInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://bali.new127.ru")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        retrofitWeather = new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        converter = new Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        converterInterface = converter.create(ConverterInterface.class);

        baliDataInterface = retrofit.create(BaliDataInterface.class);

        weatherInterface = retrofitWeather.create(WeatherInterface.class);

        xStreamHelper = new XStreamHelper(getApplicationContext());
    }

    public XStreamHelper getxStreamHelper() {
        return xStreamHelper;
    }

    public static BaliDataInterface getApi() {
        return baliDataInterface;
    }

    public static WeatherInterface getWeatherInterface() {
        return weatherInterface;
    }

    public static ConverterInterface getConverterApi() {
        return converterInterface;
    }
}
