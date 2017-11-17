package com.android.bali.models;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class Tickets {
    private String name;

    private Posts posts;

    private String catid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    @Override
    public String toString() {
        return "ClassTickets [name = " + name + ", posts = " + posts + ", catid = " + catid + "]";
    }
}
