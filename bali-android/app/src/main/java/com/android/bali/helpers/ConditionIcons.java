package com.android.bali.helpers;

import com.android.bali.R;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by zaur on 07/12/2017.
 */

public class ConditionIcons {

    private static Map<Integer, Integer> iconsMap = ImmutableMap.<Integer, Integer>builder()
            .put(13, R.drawable.chanceflurries)
            .put(10, R.drawable.chancerain)
            .put(6, R.drawable.chancesleet)
            .put(7, R.drawable.chancesleet)
            .put(15, R.drawable.chancesnow)
            .put(1, R.drawable.chancetstorms)
            .put(3, R.drawable.chancetstorms)
            .put(5, R.drawable.chancetstorms)
            .put(31, R.drawable.clear)
            .put(26, R.drawable.cloudy)
            .put(14, R.drawable.flurries)
            .put(20, R.drawable.fog)
            .put(21, R.drawable.hazy)
            .put(27, R.drawable.mostlycloudy)
            .put(28, R.drawable.mostlycloudy)
            .put(36, R.drawable.mostlysunny)
            .put(29, R.drawable.partlycloudy)
            .put(30, R.drawable.partlycloudy)
            .put(44, R.drawable.partlycloudy)
            .put(33 , R.drawable.partlysunny)
            .put(11, R.drawable.rain)
            .put(12, R.drawable.rain)
            .put(18, R.drawable.sleet)
            .put(16, R.drawable.snow)
            .put(32, R.drawable.sunny)
            .put(4, R.drawable.tstorms)
            .put(37, R.drawable.tstorms)
            .put(38, R.drawable.tstorms)
            .put(39, R.drawable.tstorms)
            .build();


    public static Map<Integer, Integer> getIconsMap() {
        return iconsMap;
    }

    public static void setIconsMap(Map<Integer, Integer> iconsMap) {
        ConditionIcons.iconsMap = iconsMap;
    }
}
