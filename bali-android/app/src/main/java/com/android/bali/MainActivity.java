package com.android.bali;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Bali");
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }
}
