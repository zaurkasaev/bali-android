package com.android.bali.models;

import java.util.List;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class Categories {
    private List<Category> category;

    public List<Category> getCategory ()
    {
        return category;
    }

    public void setCategory (List<Category> category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "ClassCategories [category = "+category+"]";
    }
}
