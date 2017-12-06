package com.android.bali.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.adapters.ForecastAdapter;
import com.android.bali.models.weather.Forecast;
import com.android.bali.models.weather.Root;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class WeatherFragment extends Fragment {
    String query = "select * from weather.forecast where woeid in (select woeid  from geo.places(1) where text=\"Denpasar\")and u='c'";
    String format = "json";

    TextView degrees;
    TextView location;
    TextView condition;

    ForecastAdapter adapter;

    RecyclerView listView;

    ArrayList<Forecast> forecasts;

    App app;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        degrees = view.findViewById(R.id.degrees_tv);
        location = view.findViewById(R.id.location_tv);
        condition = view.findViewById(R.id.condition_tv);

        listView = view.findViewById(R.id.forecast_list);

        forecasts = new ArrayList<>();

        app = (App) getContext().getApplicationContext();

        App.getWeatherInterface().getWeather(query, format).enqueue(new Callback<Root>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                degrees.setText(response.body().getQuery().getResults().getChannel().getItem().getCondition().getTemp() + (char) 0x00B0);
                location.setText(response.body().getQuery().getResults().getChannel().getLocation().getCity());
                condition.setText(response.body().getQuery().getResults().getChannel().getItem().getCondition().getText());

                forecasts.addAll(response.body().getQuery().getResults().getChannel().getItem().getForecast());

                listView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

                adapter = new ForecastAdapter(forecasts, getContext());

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

                Log.e("Err", t.getMessage());
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
