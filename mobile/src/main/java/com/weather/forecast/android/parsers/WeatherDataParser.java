package com.weather.forecast.android.parsers;

import com.weather.forecast.android.data.Weather;
import com.weather.forecast.android.data.WeatherData;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * Created by Prayansh on 16-07-10.
 */
public class WeatherDataParser {
    /**
     * Utility function to parse Json Query
     *
     * @param data
     * @return parsed WeatherData object
     * @throws JsonException on Json Format error
     */
    public static WeatherData JsonWeatherParse(String data) throws JsonException {
        JsonReader reader = Json.createReader(new StringReader(data));
        JsonObject jsonData = reader.readObject();
        JsonArray weather = jsonData.getJsonArray("weather");
        List<Weather> wData = getWeather(weather);

        JsonObject mainData = jsonData.getJsonObject("main");
        double temp = mainData.getJsonNumber("temp").doubleValue();
        double tempMax = mainData.getJsonNumber("temp_max").doubleValue();
        double tempMin = mainData.getJsonNumber("temp_min").doubleValue();
        double seaPres = -1;
        double grdPres = -1;
        double pres = mainData.getJsonNumber("pressure").doubleValue();
        int humidity = mainData.getInt("humidity");
        if (mainData.get("grnd_level") != null)
            grdPres = mainData.getJsonNumber("grnd_level").doubleValue();
        if (mainData.get("sea_level") != null)
            seaPres = mainData.getJsonNumber("sea_level").doubleValue();

        JsonObject windData = jsonData.getJsonObject("wind");
        double windSpeed = windData.getJsonNumber("speed").doubleValue();
        int windOrient = windData.getInt("deg");

        int cloudiness = jsonData.getJsonObject("clouds").getInt("all");
        JsonObject sysData = jsonData.getJsonObject("sys");
        long rise = sysData.getJsonNumber("sunrise").longValue();
        long set = sysData.getJsonNumber("sunset").longValue();

        long fetch = jsonData.getJsonNumber("dt").longValue();
        double rainVol = -1, snowVol = -1;
        if (jsonData.get("rain") != null)
            rainVol = jsonData.getJsonObject("rain").getJsonNumber("3h").doubleValue();
        if (jsonData.get("snow") != null)
            snowVol = jsonData.getJsonObject("snow").getJsonNumber("3h").doubleValue();
        return new WeatherData(temp, tempMin, tempMax, pres, seaPres, grdPres, humidity, windSpeed,
                windOrient, cloudiness, rise, set, fetch, rainVol, snowVol, wData);
    }

    /**
     * Utility function to parse forcast data.
     * This is a list of weather data which depicts forecast of particular city
     * Does not have sunset and sunrise data.
     *
     * @param data
     * @return
     * @throws JsonException
     */
    public static List<WeatherData> JsonForecastParse(String data) throws JsonException {
        List<WeatherData> result = new ArrayList<>();
        JsonReader reader = Json.createReader(new StringReader(data));
        JsonObject jsonData = reader.readObject();
        JsonArray weatherList = jsonData.getJsonArray("list");
        for (int i = 0; i < weatherList.size(); i++) {
            JsonObject tmp = weatherList.getJsonObject(i);
            JsonArray weather = tmp.getJsonArray("weather");
            List<Weather> wData = getWeather(weather);

            long fetch = tmp.getJsonNumber("dt").longValue();

            JsonObject mainData = tmp.getJsonObject("main");
            double temp = mainData.getJsonNumber("temp").doubleValue();
            double tempMax = mainData.getJsonNumber("temp_max").doubleValue();
            double tempMin = mainData.getJsonNumber("temp_min").doubleValue();
            double seaPres = -1;
            double grdPres = -1;
            double pres = mainData.getJsonNumber("pressure").doubleValue();
            int humidity = mainData.getInt("humidity");
            if (mainData.get("grnd_level") != null)
                grdPres = mainData.getJsonNumber("grnd_level").doubleValue();
            if (mainData.get("sea_level") != null)
                seaPres = mainData.getJsonNumber("sea_level").doubleValue();

            JsonObject windData = tmp.getJsonObject("wind");
            double windSpeed = windData.getJsonNumber("speed").doubleValue();
            int windOrient = windData.getInt("deg");

            int cloudiness = tmp.getJsonObject("clouds").getInt("all");
            double rainVol = -1, snowVol = -1;
            if (tmp.get("rain") != null && tmp.getJsonObject("rain").get("3h") != null)
                rainVol = tmp.getJsonObject("rain").getJsonNumber("3h").doubleValue();
            if (tmp.get("snow") != null && tmp.getJsonObject("snow").get("3h") != null)
                snowVol = tmp.getJsonObject("snow").getJsonNumber("3h").doubleValue();

            result.add(new WeatherData(temp, tempMin, tempMax, pres, seaPres, grdPres, humidity, windSpeed,
                    windOrient, cloudiness, -1, -1, fetch, rainVol, snowVol, wData));
        }
        return result;
    }

    /**
     * Helper Method to gather weather type data
     *
     * @param weather
     * @return a list of available weather types in json query
     * @throws JsonException on json format error
     */
    private static List<Weather> getWeather(JsonArray weather) throws JsonException {
        List<Weather> result = new ArrayList<>();
        for (int i = 0; i < weather.size(); i++) {
            JsonObject tmp = weather.getJsonObject(i);
            int weatherId = tmp.getInt("id");
            String weatherDesc = tmp.getString("description");
            result.add(new Weather(weatherId, weatherDesc));
        }
        return result;
    }
}
