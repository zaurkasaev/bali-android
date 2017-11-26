package com.android.bali.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.bali.App;
import com.android.bali.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class ConverterFragment extends Fragment {

    App app;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_converter, container, false);

        app= (App) getContext().getApplicationContext();

        App.getConverterApi().getStringData().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s=response.body();
                app.getxStreamHelper().getCourse(s);

                String d=app.getxStreamHelper().getValutes().get(1).getValue();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Err",t.getMessage());
            }
        });

        return view;    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
