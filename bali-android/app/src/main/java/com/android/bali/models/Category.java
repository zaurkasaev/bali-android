package com.android.bali.models;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class Category {
    private String buttonURL;

    private String name;

    private Posts posts;

    private String image;

    private String catid;

    private String buttonText;

    public String getButtonURL ()
    {
        return buttonURL;
    }

    public void setButtonURL (String buttonURL)
    {
        this.buttonURL = buttonURL;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Posts getPosts ()
    {
        return posts;
    }

    public void setPosts (Posts posts)
    {
        this.posts = posts;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getCatid ()
    {
        return catid;
    }

    public void setCatid (String catid)
    {
        this.catid = catid;
    }

    public String getButtonText ()
    {
        return buttonText;
    }

    public void setButtonText (String buttonText)
    {
        this.buttonText = buttonText;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [buttonURL = "+buttonURL+", name = "+name+", posts = "+posts+", image = "+image+", catid = "+catid+", buttonText = "+buttonText+"]";
    }
}
