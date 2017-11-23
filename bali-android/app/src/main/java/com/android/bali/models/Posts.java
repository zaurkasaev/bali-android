package com.android.bali.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by zaur_ on 14-Nov-17.
 */
public class Posts {

    private List<Post> post;

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "ClassPosts [post = " + post + "]";
    }
}
