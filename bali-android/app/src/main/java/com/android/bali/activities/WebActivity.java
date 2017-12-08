package com.android.bali.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.android.bali.App;
import com.android.bali.R;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    App app;

    int ticket;
    int category;
    int post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        app = (App) getApplicationContext();
        Bundle bundle = getIntent().getExtras();


        webView = findViewById(R.id.web_view);




        if (bundle!=null){
            if(bundle.get("category")!=null) {
                category = (int) bundle.get("category");
                post = (int) bundle.get("post");
                webView.loadUrl(app.getxStreamHelper().getCategories().get(category).getPosts().getPost().get(post).getUrl());
            }
            if(bundle.get("ticket")!=null) {
                ticket= (int) bundle.get("ticket");
                webView.loadUrl(app.getxStreamHelper().getTickets().get(ticket).getUrl());
            }
        }
    }
}
