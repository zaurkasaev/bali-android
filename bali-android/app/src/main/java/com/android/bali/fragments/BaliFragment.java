package com.android.bali.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.android.bali.models.Data;
import com.android.bali.models.Posts;

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



//        App.getApi().getData().enqueue(new Callback<Data>() {
//            @Override
//            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
//                String s=response.body().getButtonURL();
//                if (s!=null) {
//                    categories.addAll(response.body().getCategories().getCategory());
//
//                }else Toast.makeText(app, "error", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
//                Toast.makeText(app, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });

        categories = app.getxStreamHelper().getCategories();
        adapter = new CategoriesAdapter(getContext(), categories);
        listView.setAdapter(adapter);
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
