package com.android.bali.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

import com.android.bali.App;
import com.android.bali.R;
import com.android.bali.adapters.PostAdapter;
import com.android.bali.models.Post;


import java.util.ArrayList;

public class PostsActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Post> posts;
    App app;
    PostAdapter adapter;
    int category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        app = (App) getApplicationContext();

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            category= (int) bundle.get("category");
        }
        listView = findViewById(R.id.posts_list_items);

        posts = app.getxStreamHelper().getPosts(category);

        adapter = new PostAdapter(this, posts);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PostsActivity.this, WebActivity.class);
                intent.putExtra("category",category);
                intent.putExtra("post",position);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        adapter.clearList();
    }
}
