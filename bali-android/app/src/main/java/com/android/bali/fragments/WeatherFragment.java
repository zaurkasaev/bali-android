package com.android.bali.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.models.weather.Query;
import com.android.bali.models.weather.Root;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class WeatherFragment extends Fragment {
    String query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"Denpasar\")";
    String format = "json";

    App app;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        app= (App) getContext().getApplicationContext();

        App.getWeatherInterface().getWeather(query, format).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                String s = response.body().getQuery().getResults().getChannel().getItem().getForecast().get(0).getDate();
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
            Log.e("Err",t.getMessage());
            }
        });




        return view;    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
