package com.android.bali.models.weather;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Wind {
    private String speed;

    private String direction;

    private String chill;

    public String getSpeed ()
    {
        return speed;
    }

    public void setSpeed (String speed)
    {
        this.speed = speed;
    }

    public String getDirection ()
    {
        return direction;
    }

    public void setDirection (String direction)
    {
        this.direction = direction;
    }

    public String getChill ()
    {
        return chill;
    }

    public void setChill (String chill)
    {
        this.chill = chill;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [speed = "+speed+", direction = "+direction+", chill = "+chill+"]";
    }
}
