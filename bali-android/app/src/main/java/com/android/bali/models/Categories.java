package com.android.bali.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import retrofit2.http.Query;

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
