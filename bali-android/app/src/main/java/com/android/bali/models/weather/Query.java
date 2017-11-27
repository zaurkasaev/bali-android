package com.android.bali.models.weather;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Query {
    private Results results;

    private String count;

    private String created;

    private String lang;

    public Results getResults ()
    {
        return results;
    }

    public void setResults (Results results)
    {
        this.results = results;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", count = "+count+", created = "+created+", lang = "+lang+"]";
    }
}
