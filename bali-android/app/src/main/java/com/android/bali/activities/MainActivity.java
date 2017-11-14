package com.android.bali.activities;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.android.bali.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FragmentManager manager;
    Menu menu;
    int previous = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Bali");
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        addIcons();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction;
                addIcons();

//                hideFragment(previous);
//                showFragment(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        menu.clear();
//                        getMenuInflater().inflate(R.menu.capture_menu, menu);
                        getSupportActionBar().setTitle("Bali");

                        break;
                    case 1:
                        menu.clear();
                        getSupportActionBar().setTitle("Whether");
                        break;
                    case 2:
                        menu.clear();
                        getSupportActionBar().setTitle("Converter");
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Hello " + tab.getText(), Toast.LENGTH_SHORT).show();
                }
                previous = tab.getPosition();

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    void addIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.plaane);
        tabLayout.getTabAt(1).setIcon(R.drawable.sun);
        tabLayout.getTabAt(2).setIcon(R.drawable.transaction);
    }

}
