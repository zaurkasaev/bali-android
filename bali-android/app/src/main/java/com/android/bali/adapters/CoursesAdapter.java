package com.android.bali.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bali.R;

import java.util.ArrayList;

/**
 * Created by zaur_ on 01-Dec-17.
 */

public class CoursesAdapter extends BaseAdapter {

    ArrayList<String> countriesName;
    ArrayList<Integer> countriesImage;
    Context context;

    public CoursesAdapter(ArrayList<String> countriesName, ArrayList<Integer> countriesImage, Context context) {
        this.countriesName = countriesName;
        this.countriesImage = countriesImage;
        this.context = context;
    }

    private class CoursesViewHolder {

        ImageView countryImg;
        TextView countryVal;

        CoursesViewHolder(View itemView) {
            countryVal=itemView.findViewById(R.id.cours_name);
            countryImg=itemView.findViewById(R.id.cours_image);
        }

        void SetData(int position) {
            countryImg.setImageResource(countriesImage.get(position));
            countryVal.setText(countriesName.get(position));

        }


    }

    @Override
    public int getCount() {
        return countriesName.size();
    }

    @Override
    public Object getItem(int position) {
        return countriesName.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CoursesAdapter.CoursesViewHolder holder;
        try {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.courses_view, parent, false);
                holder = new CoursesViewHolder(convertView);
                convertView.setTag(holder);
            } else
                holder = (CoursesViewHolder) convertView.getTag();

            holder.SetData(position);

            Log.i("getView", String.valueOf(position));
        } catch (Exception e) {
            String s = e.getMessage();
        }
        return convertView;
    }

}
