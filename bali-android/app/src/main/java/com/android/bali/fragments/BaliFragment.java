package com.android.bali.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.adapters.CategoriesAdapter;
import com.android.bali.models.Category;

import java.util.ArrayList;

/**
 * Created by zaur_ on 13-Nov-17.
 */

public class BaliFragment extends Fragment {

    private ListView listView;
    private CategoriesAdapter adapter;
    private ArrayList<Category> categories;
    App app;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bali, container, false);

        listView = view.findViewById(R.id.bali_list_items);
        app = (App) getContext().getApplicationContext();
        categories=app.getxStreamHelper().getCategories();
        adapter = new CategoriesAdapter(this.getContext(), R.layout.categories_view, categories);
        listView.setAdapter(adapter);

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
}
