package com.android.bali.models;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class Posts {
    private Post[] post;

    public Post[] getPost ()
    {
        return post;
    }

    public void setPost (Post[] post)
    {
        this.post = post;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [post = "+post+"]";
    }
}
