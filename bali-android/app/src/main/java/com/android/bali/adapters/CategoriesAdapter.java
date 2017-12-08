package com.android.bali.adapters;

import android.annotation.SuppressLint;
import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.models.Category;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by zaur_ on 17.11.2017.
 */

public class CategoriesAdapter extends BaseAdapter {

    private ArrayList<Category> categories;
    private Context context;

    public CategoriesAdapter(Context context, ArrayList<Category> objects) {
        categories = objects;
        this.context = context;
    }

    private class CategoriesViewHolder {

        ImageView catImage;
        TextView catText;

        CategoriesViewHolder(View itemView) {
            catImage = itemView.findViewById(R.id.categories_image);
            catText = itemView.findViewById(R.id.categories_text);
        }

        void SetData(final Category category) {
            Glide.with(context)
                    .load(category.getImage())
                    .error(R.drawable.bali_image)
                    .fitCenter()
                    .into(catImage);
            catText.setText(category.getName());
        }


    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("RtlHardcoded")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final CategoriesViewHolder holder;
        try {
            Category category = (Category) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.categories_view, parent, false);
                holder = new CategoriesViewHolder(convertView);
                convertView.setTag(holder);
            } else
                holder = (CategoriesViewHolder) convertView.getTag();

            holder.SetData(category);
            if (position % 2 == 0) {
                holder.catText.setGravity(Gravity.LEFT);
            }else holder.catText.setGravity(Gravity.RIGHT);

            Log.i("getView", String.valueOf(position));
        } catch (Exception e) {
            String s = e.getMessage();
        }
        return convertView;
    }
}
