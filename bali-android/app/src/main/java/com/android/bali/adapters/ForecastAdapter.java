package com.android.bali.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.bali.R;
import com.android.bali.models.weather.Forecast;

import java.util.ArrayList;

/**
 * Created by zaur_ on 05-Dec-17.
 */


public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    ArrayList<Forecast> forecasts;
    Context context;

    public ForecastAdapter(ArrayList<Forecast> forecasts, Context context) {
        this.forecasts = forecasts;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView day;
        TextView condition;
        TextView high;
        TextView low;

       private   ViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.forecast_week_day);
            condition = itemView.findViewById(R.id.forecast_condition);
            high = itemView.findViewById(R.id.forecast_high);
            low = itemView.findViewById(R.id.forecast_low);
        }


        void setData(Forecast forecast) {

        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.day.setText(forecasts.get(position).getDay());
        holder.condition.setText(forecasts.get(position).getText());
        holder.high.setText(forecasts.get(position).getHigh());
        holder.low.setText(forecasts.get(position).getLow());
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }


}
