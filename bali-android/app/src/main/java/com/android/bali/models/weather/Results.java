package com.android.bali.models.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Results {
    @SerializedName("channel")
    @Expose
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
