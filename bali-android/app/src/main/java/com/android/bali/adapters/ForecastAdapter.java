package com.android.bali.adapters;

import android.content.Context;
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

public class ForecastAdapter extends BaseAdapter {

    ArrayList<Forecast> forecasts;
    Context context;

    public ForecastAdapter(ArrayList<Forecast> forecasts, Context context) {
        this.forecasts = forecasts;
        this.context = context;
    }

    private class ForecastViewHolder {

        TextView day;
        TextView condition;
        TextView high;
        TextView low;

        ForecastViewHolder(View itemView) {
            day = itemView.findViewById(R.id.forecast_week_day);
            condition = itemView.findViewById(R.id.forecast_condition);
            high = itemView.findViewById(R.id.forecast_high);
            low = itemView.findViewById(R.id.forecast_low);
        }

        void setData(Forecast forecast) {
            day.setText(forecast.getDay());
            condition.setText(forecast.getText());
            high.setText(forecast.getHigh());
            low.setText(forecast.getLow());
        }

    }

    @Override
    public int getCount() {
        return forecasts.size();
    }

    @Override
    public Object getItem(int position) {
        return forecasts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ForecastAdapter.ForecastViewHolder holder;
        try {
            Forecast forecast = (Forecast) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.forecast_view, parent, false);
                holder = new ForecastAdapter.ForecastViewHolder(convertView);
                convertView.setTag(holder);
            } else
                holder = (ForecastAdapter.ForecastViewHolder) convertView.getTag();

            holder.setData(forecast);
        } catch (Exception e) {
            String s = e.getMessage();
        }
        return convertView;
    }
}
