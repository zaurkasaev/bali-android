package com.android.bali.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.activities.CourseActivity;
import com.android.bali.adapters.CoursesAdapter;
import com.android.bali.models.convertor.Data;
import com.meetic.marypopup.MaryPopup;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class ConverterFragment extends Fragment {

    EditText inputValut;
    EditText outputValut;

    ImageView inputImage;
    App app;

    double current;

    String baseCourse = "USD";

    private double output;
    private double input;
    private String out;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_converter, container, false);

        inputValut = view.findViewById(R.id.conv_input);
        outputValut = view.findViewById(R.id.conv_output);
        inputImage = view.findViewById(R.id.conv_input_image);
        app = (App) getContext().getApplicationContext();
        App.getConverterApi().getData(baseCourse).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                current = response.body().getRates().getRUB();
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });

        inputValut.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("before", s.toString());
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("now", s.toString());
                if (s.length() > 0) {
                    input = Double.parseDouble(s.toString());
                    output = input * current;
                    out = String.format(Locale.ENGLISH, "%.2f", output);
                    outputValut.setText(out);
                } else {
                    outputValut.setText("");
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("after", s.toString());
            }
        });

        inputImage.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), CourseActivity.class);
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
