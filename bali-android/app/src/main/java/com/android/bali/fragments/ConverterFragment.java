package com.android.bali.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.bali.App;
import com.android.bali.R;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class ConverterFragment extends Fragment {

    EditText inputValut;
    TextView outputValut;
    App app;

    String current;
    Double d = 0.0;

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
        app = (App) getContext().getApplicationContext();

        App.getConverterApi().getStringData().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body();
                app.getxStreamHelper().getCourse(s);

                current = app.getxStreamHelper().getValutes().get(1).getValue();
                NumberFormat format = NumberFormat.getInstance(Locale.FRENCH);
                try {
                    d = format.parse(current).doubleValue();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Err", t.getMessage());
            }
        });

        inputValut.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("Zaur1",s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("Zaur",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("Zaur2",s.toString());
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
}
