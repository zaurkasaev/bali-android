package com.android.bali.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.activities.PostsActivity;
import com.android.bali.adapters.CategoriesAdapter;
import com.android.bali.models.Category;
import com.android.bali.models.Posts;

import java.util.ArrayList;

/**
 * Created by zaur_ on 13-Nov-17.
 */

public class BaliFragment extends Fragment {

    private ListView listView;
    private CategoriesAdapter adapter;
    ArrayList<Category> categories;
    Posts posts;
    App app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bali, container, false);

        listView = view.findViewById(R.id.bali_list_items);
        app = (App) getContext().getApplicationContext();
        categories = app.getxStreamHelper().getCategories();
        adapter = new CategoriesAdapter(this.getContext(), categories);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), app.getxStreamHelper().getCategories().get(i).getPosts().getPost().get(i).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),PostsActivity.class);
                intent.putExtra("category",i);
                startActivity(intent);

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
        adapter.notifyDataSetChanged();
    }
}
