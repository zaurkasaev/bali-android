package com.android.bali.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.adapters.TicketsAdapter;
import com.android.bali.models.Post;

import java.util.ArrayList;

/**
 * Created by zaur_ on 17.11.2017.
 */

public class TicketsFragment extends Fragment {

    ArrayList<Post> posts;
    App app;
    TicketsAdapter adapter;
    GridView gridView;

    Integer width;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);

        CalculateItemHeight();

        gridView = view.findViewById(R.id.tickets_grid_view);

        app = (App) getContext().getApplicationContext();

        posts = app.getxStreamHelper().getTickets();

        adapter = new TicketsAdapter(getContext(), posts,width);

        gridView.setAdapter(adapter);

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

    public void CalculateItemHeight() {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int widthDisplay = displayMetrics.widthPixels;
        width = (widthDisplay / 2 - 30);
    }
}
