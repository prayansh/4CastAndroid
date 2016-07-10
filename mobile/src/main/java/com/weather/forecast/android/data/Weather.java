package com.weather.forecast.android.data;

/**
 * Created by Prayansh on 16-07-10.
 */
public class Weather {
    private WeatherStat stat;
    private String desc;
//    http://openweathermap.org/weather-conditions
//    TODO Pavan create weather codes from above site

    public WeatherStat getStat() {
        return stat;
    }

    public String getDesc() {
        return desc;
    }
}
