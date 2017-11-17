package com.android.bali.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.models.Category;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by zaur_ on 17.11.2017.
 */

public class CategoriesAdapter extends BaseAdapter/*ArrayAdapter<Category> */{

    private ArrayList<Category> categories;
    private Context context;
    private App app;
    private Picasso picasso;

    public CategoriesAdapter(Context context, /*int resource,*/ ArrayList<Category> objects) {
        //super(context, resource);
        categories = objects;
        this.context = context;
        app = (App) context.getApplicationContext();
//        picasso = new Picasso.Builder(context)
//                .listener(new Picasso.Listener() {
//                    @Override
//                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
//                        //Here your log
//                        Log.d("Picasso", exception.getLocalizedMessage());
//                    }
//                })
//                .build();
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

            Log.i("getView", String.valueOf(position));
        } catch (Exception e) {
            String s = e.getMessage();
        }
        return convertView;
    }
}
