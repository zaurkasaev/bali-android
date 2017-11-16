package com.android.bali.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.bali.R;
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

/**
 * Created by zaur_ on 13-Nov-17.
 */

public class BaliFragment extends Fragment {

    TextView textView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bali, container, false);
        textView = view.findViewById(R.id.t_v);
        try {
            InputStream fileReader;
            fileReader = getActivity().getAssets().open("codebeautify.xml");
            XStream xs = new XStream();
            xs.alias("data", Data.class);
//            xs.addImplicitCollection(Data.class,"categories");
//            xs.addImplicitCollection(Data.class,"tickets");

            xs.alias("categories", Categories.class);
//            xs.addImplicitCollection(Categories.class,"category");

            xs.alias("category",Category.class);
//            xs.addImplicitCollection(Category.class,"posts");

            xs.alias("posts",Posts.class);
            xs.addImplicitCollection(Posts.class, "post");
            xs.alias("post",Post.class);

            xs.alias("tickets", Tickets.class);
//            xs.addImplicitCollection(Tickets.class,"posts");

            xs.alias("posts",Posts.class);
            xs.addImplicitCollection(Posts.class, "post");
            xs.alias("post",Post.class);

            Data data = (Data) xs.fromXML(fileReader);

            textView.setText(data.getCategories().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
