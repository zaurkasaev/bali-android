package com.android.bali.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.models.Posts;

/**
 * Created by zaur_ on 19.11.2017.
 */

public class PostsFragment extends Fragment {

    private ListView listView;
    Posts posts;
    App app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bali, container, false);

        listView = view.findViewById(R.id.bali_list_items);
        app = (App) getContext().getApplicationContext();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), app.getxStreamHelper().getCategories().get(i).getPosts().getPost().get(i).getTitle(), Toast.LENGTH_SHORT).show();
                posts.setPost(app.getxStreamHelper().getCategories().get(i).getPosts().getPost());

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

    @Override
    public void onStart() {
        super.onStart();
    }
}
