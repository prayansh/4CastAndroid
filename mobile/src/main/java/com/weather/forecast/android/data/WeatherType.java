package com.weather.forecast.android.data;


public enum WeatherType {
    THUNDERSTORM, DRIZZLE, RAIN, SNOW, ATMOSPHERE, SKY, EXTREME, ADDITIONAL;

    public static WeatherType statGenerator(int weatherId) {
        if (weatherId >= 200 && weatherId < 300) {
            return THUNDERSTORM;
        } else if (weatherId >= 300 && weatherId < 400) {
            return DRIZZLE;
        } else if (weatherId >= 500 && weatherId < 600) {
            return RAIN;
        } else if (weatherId >= 600 && weatherId < 700) {
            return SNOW;
        } else if (weatherId >= 700 && weatherId < 800) {
            return ATMOSPHERE;
        } else if (weatherId >= 800 && weatherId < 900) {
            return SKY;
        } else if (weatherId >= 900 && weatherId < 910) {
            return EXTREME;
        } else if (weatherId >= 910 && weatherId < 1000) {
            return ADDITIONAL;
        }
        return ADDITIONAL;
    }
}
