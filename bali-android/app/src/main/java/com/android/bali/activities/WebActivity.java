package com.android.bali.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.android.bali.App;
import com.android.bali.R;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    App app;

    int category;
    int post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            category= (int) bundle.get("category");
            post= (int) bundle.get("post");
        }

        webView = findViewById(R.id.web_view);

        app = (App) getApplicationContext();

        webView.loadUrl(app.getxStreamHelper().getCategories().get(category).getPosts().getPost().get(post).getUrl());
    }
}
