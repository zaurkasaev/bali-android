package com.android.bali.models.weather;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Results {
    private Channel channel;

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channel = "+channel+"]";
    }
}
