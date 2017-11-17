package com.android.bali.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class CategoriesAdapter extends ArrayAdapter<Category> {

    ArrayList<Category> categories;
    Context context;
    App app;

    public CategoriesAdapter(@NonNull Context context, int resource, ArrayList<Category> categories) {
        super(context, resource);
        this.categories = categories;
        this.context = context;
        this.app = (App) context.getApplicationContext();
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
                    .error(R.mipmap.ic_launcher)
                    .fitCenter()
                    .into(catImage);
            catText.setText(category.getName());
        }


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final CategoriesViewHolder holder;
        try {
            Category category = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.categories_view, parent, false);
                holder = new CategoriesViewHolder(convertView);
                convertView.setTag(holder);
            } else
                holder = (CategoriesViewHolder) convertView.getTag();
            holder.SetData(category);

            Log.i("getView", String.valueOf(position));
        } catch (Exception e) {
            String s = e.getMessage();
        }
        return convertView;
    }
}
