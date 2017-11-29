package com.android.bali.helpers;

import android.content.Context;

import com.android.bali.models.Categories;
import com.android.bali.models.Category;
import com.android.bali.models.Data;
import com.android.bali.models.Post;
import com.android.bali.models.Posts;
import com.android.bali.models.Tickets;
import com.android.bali.models.convertor.ValCurs;
import com.android.bali.models.convertor.Valute;
import com.android.bali.models.weather.Astronomy;
import com.android.bali.models.weather.Atmosphere;
import com.android.bali.models.weather.Channel;
import com.android.bali.models.weather.Condition;
import com.android.bali.models.weather.Forecast;
import com.android.bali.models.weather.Image;
import com.android.bali.models.weather.Item;
import com.android.bali.models.weather.Location;
import com.android.bali.models.weather.Query;
import com.android.bali.models.weather.Results;
import com.android.bali.models.weather.Units;
import com.android.bali.models.weather.Wind;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;


/**
 * Created by zaur_ on 17.11.2017.
 */

public class XStreamHelper {

    private Context context;

    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Post> tickets = new ArrayList<>();
    private ArrayList<Valute> valutes = new ArrayList<>();



    Data data;

    ValCurs valCurs;




    public XStreamHelper(Context context) {
        this.context = context;
    }

    public void getData(String tmp) {

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

        xs.processAnnotations(Post.class);
        data = (Data) xs.fromXML(tmp);
        categories.addAll(data.getCategories().getCategory());
        tickets.addAll(data.getTickets().getPosts().getPost());
    }

    public void getCourse(String tmp) {
        XStream xs = new XStream();

        xs.alias("ValCurs", ValCurs.class);
        xs.addImplicitCollection(ValCurs.class, "Valute");

        xs.alias("Valute", Valute.class);


        valCurs = (ValCurs) xs.fromXML(tmp);

        valutes.addAll(valCurs.getValute());
    }


    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Post> getTickets() {
        return tickets;
    }

    public ArrayList<Post> getPosts(int category) {
        posts.addAll(data.getCategories().getCategory().get(category).getPosts().getPost());
        return posts;
    }

    public ArrayList<Valute> getValutes() {
        return valutes;
    }

}
