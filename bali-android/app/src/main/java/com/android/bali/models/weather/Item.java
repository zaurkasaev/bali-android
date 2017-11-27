package com.android.bali.models.weather;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Item {

    private Guid guid;

    private String pubDate;

    private String title;


    private List<Forecast> forecast;
    @XStreamAlias("yweather:condition")
    private Condition condition;

    private String description;

    private String link;
    @XStreamAlias("geo:long")
    private String _long;
    @XStreamAlias("geo:lat")
    private String lat;

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "ClassPojo [guid = " + guid + ", pubDate = " + pubDate + ", title = " + title + ", forecast = " + forecast + ", condition = " + condition + ", description = " + description + ", link = " + link + ", long = " + _long + ", lat = " + lat + "]";
    }
}
