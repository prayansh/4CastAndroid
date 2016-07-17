package com.weather.forecast.android.data;

/**
 * Created by Prayansh on 16-07-10.
 */
public class Weather {
    private WeatherType type;
    private String desc;

    public Weather(int statId, String desc) {
        type = WeatherType.statGenerator(statId);
        this.desc = desc;
    }

    public WeatherType getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
