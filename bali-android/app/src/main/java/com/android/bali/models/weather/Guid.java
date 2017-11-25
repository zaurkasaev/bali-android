package com.android.bali.models.weather;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Guid {
    private String isPermaLink;

    public String getIsPermaLink ()
    {
        return isPermaLink;
    }

    public void setIsPermaLink (String isPermaLink)
    {
        this.isPermaLink = isPermaLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [isPermaLink = "+isPermaLink+"]";
    }
}
