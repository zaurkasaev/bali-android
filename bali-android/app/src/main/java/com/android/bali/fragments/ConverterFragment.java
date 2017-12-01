package com.android.bali.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.adapters.CoursesAdapter;
import com.android.bali.models.convertor.Data;
import com.meetic.marypopup.MaryPopup;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class ConverterFragment extends Fragment {

    TextInputLayout textInputLayout;
    TextInputEditText inputValut;
    TextInputLayout textOutputLayout;
    TextInputEditText outputValut;

    ImageView inputImage;
    ImageView outputImage;
    App app;

    double current;

    String baseCourse;
    int baseOutputCourse;

    private double output;
    private double input;
    private String out;
    private int popupHeight;
    private int popupWidth;
    ArrayList<String> countriesName;
    ArrayList<Integer> countriesImage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_converter, container, false);

        CalculateItemHeight();
        init();
        inputValut = view.findViewById(R.id.conv_input);
        outputValut = view.findViewById(R.id.conv_output);
        textInputLayout = view.findViewById(R.id.conv_input_layout);
        textOutputLayout = view.findViewById(R.id.conv_output_layout);
        inputImage = view.findViewById(R.id.conv_input_image);
        outputImage = view.findViewById(R.id.conv_output_image);
        app = (App) getContext().getApplicationContext();
        baseCourse = countriesName.get(0);
        baseOutputCourse = 1;
        initData(baseCourse, baseOutputCourse);
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
            popup("input");

        });
        outputImage.setOnClickListener(v -> {
            popup("output");
        });


        return view;
    }

    public void popup(String type) {

        MaryPopup maryPopup = MaryPopup.with(getActivity());
        View pw = getLayoutInflater().inflate(R.layout.popup_view, null);
        ListView listView = pw.findViewById(R.id.popup_list);
        CoursesAdapter adapter = new CoursesAdapter(countriesName, countriesImage, getContext());
        listView.setAdapter(adapter);

        maryPopup.cancellable(true)
                .center(true)
                .draggable(true)
                .width(popupWidth)
                .content(pw)
                .from(getView())
                .show();

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            if(Objects.equals(type, "input")) {
                if (Objects.equals(baseCourse, countriesName.get(position))) {
                    Toast.makeText(app, "Current", Toast.LENGTH_SHORT).show();
                } else {
                    baseCourse = countriesName.get(position);
                    if (inputValut.getText() != null) {
                        inputValut.setText("");
                        inputValut.setHint("");

                    }
                    textInputLayout.setHint(countriesName.get(position));
                    inputImage.setImageResource(countriesImage.get(position));
                    maryPopup.close(true);
                    if (position != baseOutputCourse) {
                        initData(baseCourse, baseOutputCourse);
                    } else if (position + 1 > 3) {
                        baseOutputCourse = position - 1;
                        initData(baseCourse, baseOutputCourse);
                    } else if (position == 0) {
                        baseOutputCourse = position + 1;
                        initData(baseCourse, baseOutputCourse);
                    } else {
                        initData(baseCourse, baseOutputCourse + 1);
                    }
                }
            }else if (Objects.equals(type, "output")){
                if (position==baseOutputCourse){
                    Toast.makeText(app, "Current", Toast.LENGTH_SHORT).show();
                }else if(Objects.equals(baseCourse, countriesName.get(position))){
                    Toast.makeText(app, "It's a base currency", Toast.LENGTH_SHORT).show();
                } else {
                    baseOutputCourse=position;
                    initData(baseCourse,baseOutputCourse);
                    maryPopup.close(true);
                }
            }
        });


    }

    public void init() {
        countriesName = new ArrayList<>();
        countriesImage = new ArrayList<>();

        countriesName.add("USD");
        countriesName.add("RUB");
        countriesName.add("IDR");
        countriesName.add("EUR");

        countriesImage.add(R.drawable.usa);
        countriesImage.add(R.drawable.russian_federation);
        countriesImage.add(R.drawable.indonesia);
        countriesImage.add(R.drawable.europe);
    }

    public void CalculateItemHeight() {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int widthDisplay = displayMetrics.widthPixels;
        int heightDisplay = displayMetrics.heightPixels;
        popupHeight = (int) (heightDisplay * 0.5);
        popupWidth = (int) (widthDisplay * 0.9);
    }

    public void initData(String base, int position) {

        App.getConverterApi().getData(base).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                switch (position) {
                    case 0:
                        current = response.body().getRates().getUSD();
                        outputImage.setImageResource(countriesImage.get(0));
                        textOutputLayout.setHint(countriesName.get(0));
                        break;
                    case 1:
                        current = response.body().getRates().getRUB();
                        outputImage.setImageResource(countriesImage.get(1));
                        textOutputLayout.setHint(countriesName.get(1));
                        break;
                    case 2:
                        current = response.body().getRates().getIDR();
                        outputImage.setImageResource(countriesImage.get(2));
                        textOutputLayout.setHint(countriesName.get(2));
                        break;
                    case 3:
                        current = response.body().getRates().getEUR();
                        outputImage.setImageResource(countriesImage.get(3));
                        textOutputLayout.setHint(countriesName.get(3));
                        break;
                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(app, "ERROR" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
