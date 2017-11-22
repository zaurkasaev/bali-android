package com.android.bali;

import android.app.Application;

import com.android.bali.helpers.XStreamHelper;

/**
 * Created by zaur_ on 17.11.2017.
 */

public class App extends Application {
    XStreamHelper xStreamHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        xStreamHelper=new XStreamHelper(getApplicationContext());
    }
    public XStreamHelper getxStreamHelper(){
        return xStreamHelper;
    }
}
