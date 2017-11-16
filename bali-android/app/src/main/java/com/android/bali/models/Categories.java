package com.android.bali.models;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class Categories {
    private Category[] category;

    public Category[] getCategory ()
    {
        return category;
    }

    public void setCategory (Category[] category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [category = "+category+"]";
    }
}
