package com.android.bali.models.convertor;

/**
 * Created by zaur_ on 26-Nov-17.
 */

public class Valute {

    private String Name;

    private String Value;

    private String ID;

    private String Nominal;

    private String CharCode;

    private String NumCode;

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    public String getValue ()
    {
        return Value;
    }

    public void setValue (String Value)
    {
        this.Value = Value;
    }

    public String getID ()
    {
        return ID;
    }

    public void setID (String ID)
    {
        this.ID = ID;
    }

    public String getNominal ()
    {
        return Nominal;
    }

    public void setNominal (String Nominal)
    {
        this.Nominal = Nominal;
    }

    public String getCharCode ()
    {
        return CharCode;
    }

    public void setCharCode (String CharCode)
    {
        this.CharCode = CharCode;
    }

    public String getNumCode ()
    {
        return NumCode;
    }

    public void setNumCode (String NumCode)
    {
        this.NumCode = NumCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Name = "+Name+", Value = "+Value+", ID = "+ID+", Nominal = "+Nominal+", CharCode = "+CharCode+", NumCode = "+NumCode+"]";
    }
}
