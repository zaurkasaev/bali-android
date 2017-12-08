package com.android.bali.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.activities.PostsActivity;
import com.android.bali.activities.WebActivity;
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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);

        gridView = view.findViewById(R.id.tickets_grid_view);

        app = (App) getContext().getApplicationContext();

        posts = app.getxStreamHelper().getTickets();

        adapter = new TicketsAdapter(getContext(), posts);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(getContext(), WebActivity.class);
            intent.putExtra("ticket", position);
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
}
