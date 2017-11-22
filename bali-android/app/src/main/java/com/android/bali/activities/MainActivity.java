package com.android.bali.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Toast;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.fragments.BaliFragment;
import com.android.bali.fragments.ConverterFragment;
import com.android.bali.fragments.TicketsFragment;
import com.android.bali.fragments.WeatherFragment;
import com.android.bali.models.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FragmentManager manager;
    Menu menu;
    int previous = 0;

    ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Bali");
        tabLayout = findViewById(R.id.tabLayout);
        categories = new ArrayList<>();

        App app = (App) getApplicationContext();

        app.getxStreamHelper().getData();


        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        addIcons();
        initFragments();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                addIcons();

                hideFragment(previous);
                showFragment(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
//                        menu.clear();
//                        getMenuInflater().inflate(R.menu.capture_menu, menu);
                        getSupportActionBar().setTitle("Bali");

                        break;
                    case 1:
                        getSupportActionBar().setTitle("Tickets");
                        break;
                    case 2:
//                        menu.clear();
                        getSupportActionBar().setTitle("Whether");
                        break;
                    case 3:
//                        menu.clear();
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

    @Override
    protected void onResume() {
        super.onResume();
        hideFragment(0);
        hideFragment(1);
        hideFragment(2);
        hideFragment(3);
        showFragment(previous);
    }

    void initFragments() {

        BaliFragment baliFragment = new BaliFragment();
        TicketsFragment ticketsFragment = new TicketsFragment();
        WeatherFragment weatherFragment = new WeatherFragment();
        ConverterFragment converterFragment = new ConverterFragment();

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.container, baliFragment, "fragBali");
        transaction.add(R.id.container, ticketsFragment, "fragTickets");
        transaction.add(R.id.container, weatherFragment, "fragWeather");
        transaction.add(R.id.container, converterFragment, "fragConverter");
        transaction.commit();
    }

    void addIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.plaane);
        tabLayout.getTabAt(1).setIcon(R.drawable.ticket);
        tabLayout.getTabAt(2).setIcon(R.drawable.sun);
        tabLayout.getTabAt(3).setIcon(R.drawable.transaction);
    }

    void hideFragment(int position) {
        switch (position) {
            case 0:
                BaliFragment baliFragment = (BaliFragment) manager.findFragmentByTag("fragBali");
                manager.beginTransaction()
                        .hide(baliFragment)
                        .commit();
                break;
            case 1:
                TicketsFragment ticketsFragment = (TicketsFragment) manager.findFragmentByTag("fragTickets");
                manager.beginTransaction()
                        .hide(ticketsFragment)
                        .commit();
                break;

            case 2:
                WeatherFragment weatherFragment = (WeatherFragment) manager.findFragmentByTag("fragWeather");
                manager.beginTransaction()
                        .hide(weatherFragment)
                        .commit();
                break;
            case 3:
                ConverterFragment converterFragment = (ConverterFragment) manager.findFragmentByTag("fragConverter");
                manager.beginTransaction()
                        .hide(converterFragment)
                        .commit();
                break;
        }
    }

    void showFragment(int position) {
        switch (position) {
            case 0:
                BaliFragment baliFragment = (BaliFragment) manager.findFragmentByTag("fragBali");
                manager.beginTransaction()
                        .show(baliFragment)
                        .commit();
                break;
            case 1:
                TicketsFragment ticketsFragment = (TicketsFragment) manager.findFragmentByTag("fragTickets");
                manager.beginTransaction()
                        .show(ticketsFragment)
                        .commit();
                break;

            case 2:
                WeatherFragment weatherFragment = (WeatherFragment) manager.findFragmentByTag("fragWeather");
                manager.beginTransaction()
                        .show(weatherFragment)
                        .commit();
                break;
            case 3:
                ConverterFragment converterFragment = (ConverterFragment) manager.findFragmentByTag("fragConverter");
                manager.beginTransaction()
                        .show(converterFragment)
                        .commit();
                break;
        }
    }

}
