package com.android.bali.helpers;

import android.content.Context;

import com.android.bali.models.Categories;
import com.android.bali.models.Category;
import com.android.bali.models.Data;
import com.android.bali.models.Post;
import com.android.bali.models.Posts;
import com.android.bali.models.Tickets;
import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by zaur_ on 17.11.2017.
 */

public class XStreamHelper {

    private Context context;
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Post> tickets = new ArrayList<>();

    public XStreamHelper(Context context) {
        this.context = context;
    }

    public void getData() {
        try {
            InputStream fileReader;
            fileReader = context.getAssets().open("codebeautify.xml");
            XStream xs = new XStream();
            xs.alias("data", Data.class);

            xs.alias("categories", Categories.class);
            xs.addImplicitCollection(Categories.class, "category");

            xs.alias("category", Category.class);

            xs.alias("posts", Posts.class);
            xs.addImplicitCollection(Posts.class, "post");
            xs.alias("post", Post.class);

            xs.alias("tickets", Tickets.class);

            xs.alias("posts", Posts.class);
            xs.addImplicitCollection(Posts.class, "post");
            xs.alias("post", Post.class);

            Data data = (Data) xs.fromXML(fileReader);
            categories.addAll(data.getCategories().getCategory());
            tickets.addAll(data.getTickets().getPosts().getPost());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Post> getTickets() {
        return tickets;
    }
}
