package com.android.bali.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bali.R;
import com.android.bali.models.Post;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by zaur_ on 19.11.2017.
 */

public class TicketsAdapter extends BaseAdapter {


    ArrayList<Post> posts;
    Context context;
    int width;

    public TicketsAdapter(Context context, ArrayList<Post> objects,int width) {
        this.context = context;
        posts = objects;
        this.width=width;

    }

    private class TicketsViewHolder {

        ImageView postImage;
        TextView postTitle;


        TicketsViewHolder(View itemView) {
            postImage = itemView.findViewById(R.id.tickets_image);
            postTitle = itemView.findViewById(R.id.tickets_text
            );

        }

        void SetData(final Post post) {
            Glide.with(context)
                    .load(post.getImage())
                    .error(R.drawable.bali_image)
                    .fitCenter()
                    .into(postImage);
            postTitle.setText(post.getTitle());
        }


    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TicketsAdapter.TicketsViewHolder holder;
        try {
            Post post = (Post) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.tickets_view, parent, false);
                holder = new TicketsAdapter.TicketsViewHolder(convertView);
                convertView.setTag(holder);
            } else
                holder = (TicketsAdapter.TicketsViewHolder) convertView.getTag();

            holder.SetData(post);

        } catch (Exception e) {
            String s = e.getMessage();
        }

        convertView.setLayoutParams(new GridView.LayoutParams(width,width));
        return convertView;
    }
}
