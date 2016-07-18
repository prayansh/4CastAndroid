package com.weather.forecast.android.parsers;

import com.weather.forecast.android.data.Weather;
import com.weather.forecast.android.data.WeatherData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prayansh on 16-07-10.
 */
public class JSONParsers {
    /**
     * Utility function to parse JSON Query
     * @param data
     * @return parsed WeatherData object
     * @throws JSONException on Json Format error
     */
    public static WeatherData JSONWeatherParse(String data) throws JSONException {
        JSONObject jsonData = new JSONObject(data);
        JSONArray weather = jsonData.getJSONArray("weather");
        List<Weather> wData = getWeather(weather);
        JSONObject mainData = jsonData.getJSONObject("main");
        double temp = mainData.getDouble("temp");
        double tempMax = mainData.getDouble("temp_max");
        double tempMin = mainData.getDouble("temp_min");
        double seaPres = -1;
        double grdPres = -1;
        double pres = mainData.getDouble("pressure");
        int humidity = mainData.getInt("humidity");
        if (mainData.has("grnd_level"))
            grdPres = mainData.getDouble("grnd_level");
        if (mainData.has("sea_level"))
            seaPres = mainData.getDouble("sea_level");
        JSONObject windData = jsonData.getJSONObject("wind");
        double windSpeed = windData.getDouble("speed");
        int windOrient = windData.getInt("deg");
        int cloudiness = jsonData.getJSONObject("clouds").getInt("all");
        JSONObject sysData = jsonData.getJSONObject("sys");
        long rise = sysData.getLong("sunrise");
        long set = sysData.getLong("sunset");
        long fetch = jsonData.getLong("dt");
        double rainVol = -1, snowVol = -1;
        if (jsonData.has("rain"))
            rainVol = jsonData.getJSONObject("rain").getDouble("3h");
        if (jsonData.has("snow"))
            snowVol = jsonData.getJSONObject("snow").getDouble("3h");
        return new WeatherData(temp, tempMin, tempMax, pres, seaPres, grdPres, humidity, windSpeed,
                windOrient, cloudiness, rise, set, fetch, rainVol, snowVol, wData);
    }

    /**
     * Helper Method to gather weather type data
     * @param weather
     * @return a list of available weather types in json query
     * @throws JSONException on json format error
     */
    private static List<Weather> getWeather(JSONArray weather) throws JSONException {
        List<Weather> result = new ArrayList<>();
        for (int i = 0; i < weather.length(); i++) {
            JSONObject tmp = weather.getJSONObject(i);
            int weatherId = tmp.getInt("id");
            String weatherDesc = tmp.getString("description");
            result.add(new Weather(weatherId, weatherDesc));
        }
        return result;
    }
}
