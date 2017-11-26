package com.android.bali.models.convertor;

import java.util.List;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class ValCurs {
    private String Date;

    private String name;

    private List<Valute> Valute;

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public List<Valute> getValute() {
        return Valute;
    }

    public void setValute(List<Valute> valute) {
        Valute = valute;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Date = "+Date+", name = "+name+", Valute = "+Valute+"]";
    }

}
