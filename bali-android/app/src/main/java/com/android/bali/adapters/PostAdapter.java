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
import com.android.bali.models.Post;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by zaur on 21.11.17.
 */

public class PostAdapter extends BaseAdapter {

    ArrayList<Post> posts;
    Context context;

    public PostAdapter(Context context, ArrayList<Post> objects) {
        this.context = context;
        posts = objects;

    }
    private class PostsViewHolder {

        ImageView postImage;
        TextView postTitle;
        TextView postAnnotation;

        PostsViewHolder(View itemView) {
            postImage = itemView.findViewById(R.id.post_image);
            postTitle = itemView.findViewById(R.id.post_title);
            postAnnotation = itemView.findViewById(R.id.post_annotation);
        }

        void SetData(final Post post) {
            Glide.with(context)
                    .load(post.getImage())
                    .error(R.drawable.bali_image)
                    .fitCenter()
                    .into(postImage);
            postTitle.setText(post.getTitle());
            postAnnotation.setText(post.getShort());
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
        final PostAdapter.PostsViewHolder holder;
        try {
            Post post = (Post) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.post_view, parent, false);
                holder = new PostAdapter.PostsViewHolder(convertView);
                convertView.setTag(holder);
            } else
                holder = (PostAdapter.PostsViewHolder) convertView.getTag();

            holder.SetData(post);

            Log.i("getView", String.valueOf(position));
        } catch (Exception e) {
            String s = e.getMessage();
        }
        return convertView;
    }
    public void clearList(){
        posts.clear();
    }
}
