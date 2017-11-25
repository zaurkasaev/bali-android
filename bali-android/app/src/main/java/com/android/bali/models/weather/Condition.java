package com.android.bali.models.weather;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Condition {
    private String text;

    private String temp;

    private String code;

    private String date;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getTemp ()
    {
        return temp;
    }

    public void setTemp (String temp)
    {
        this.temp = temp;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+", temp = "+temp+", code = "+code+", date = "+date+"]";
    }
}
