package com.android.bali.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.bali.R;
import com.android.bali.adapters.CoursesAdapter;

import java.util.ArrayList;

public class CourseActivity extends AppCompatActivity {

    private ListView listView;
    private CoursesAdapter adapter;

    private ArrayList<String> countriesName;
    private ArrayList<Integer> countriesImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        init();

        listView = findViewById(R.id.list);
        adapter = new CoursesAdapter(countriesName, countriesImage, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

        });
    }

    public void init() {
        countriesName = new ArrayList<>();
        countriesImage = new ArrayList<>();

        countriesName.add("USA");
        countriesName.add("RUD");
        countriesName.add("IDR");
        countriesName.add("EUR");

        countriesImage.add(R.drawable.usa);
        countriesImage.add(R.drawable.russian_federation);
        countriesImage.add(R.drawable.indonesia);
        countriesImage.add(R.drawable.europe);
    }
}
