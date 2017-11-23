package com.android.bali.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * Created by zaur_ on 14-Nov-17.
 */
@XStreamAlias("post")
public class Post {

    private String id;

    @XStreamAlias("short")
    private String _short;

    private String title;

    private String image;

    private String url;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getShort ()
    {
        return _short;
    }

    public void setShort (String _short)
    {
        this._short = _short;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", short = "+_short+", title = "+title+", image = "+image+", url = "+url+"]";
    }
}
