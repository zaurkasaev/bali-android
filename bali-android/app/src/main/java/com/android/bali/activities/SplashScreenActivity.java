package com.android.bali.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.bali.R;

public class SplashScreenActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler = new Handler();
        handler.postDelayed(this::callMainActivity, 3000);
    }

    private void callMainActivity(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}
