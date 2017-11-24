package com.android.bali.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.activities.PostsActivity;
import com.android.bali.adapters.CategoriesAdapter;

import com.android.bali.models.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by zaur_ on 13-Nov-17.
 */

public class BaliFragment extends Fragment {

    private ListView listView;
    private CategoriesAdapter adapter;
    ArrayList<Category> categories;
    App app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bali, container, false);

        listView = view.findViewById(R.id.bali_list_items);
        app = (App) getContext().getApplicationContext();

        App.getApi().getStringData().enqueue(new Callback<String>(){

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body();
                app.getxStreamHelper().getData(s);
                categories = app.getxStreamHelper().getCategories();
                adapter = new CategoriesAdapter(getContext(), categories);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(app, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Intent intent = new Intent(getContext(), PostsActivity.class);
            intent.putExtra("category", i);
            startActivity(intent);

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
        if (adapter!=null) {
            adapter.notifyDataSetChanged();
        }
    }
}
