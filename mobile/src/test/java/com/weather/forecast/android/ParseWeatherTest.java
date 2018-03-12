package com.weather.forecast.android;

import com.weather.forecast.android.data.WeatherData;
import com.weather.forecast.android.data.WeatherType;
import com.weather.forecast.android.parsers.WeatherDataParser;

import org.json.JSONException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class ParseWeatherTest {
    @Test
    public void testMumbai() throws JSONException {
        WeatherData data = WeatherDataParser.JsonWeatherParse(SampleData.MUM_WEATHER_DATA);
        assertEquals(298.711, data.getTemperature(), Math.pow(10, -3));
        assertEquals(298.711, data.getTemperatureMax(), Math.pow(10, -3));
        assertEquals(298.711, data.getTemperatureMin(), Math.pow(10, -3));

        assertEquals(7.46, data.getWindSpeed(), Math.pow(10, -3));
        assertEquals(248, data.getWindOrientation());

        assertEquals(1015.05, data.getPressure(), Math.pow(10, -3));
        assertEquals(1015.05, data.getGrndPressure(), Math.pow(10, -3));
        assertEquals(1015.75, data.getSeaPressure(), Math.pow(10, -3));

        assertEquals(100, data.getHumidity());
        assertEquals(92, data.getCloudiness());

        assertEquals(3.12, data.getRainVol());
        assertEquals(-1.0, data.getSnowVol());// Default Value

        assertEquals(1468111074, data.getSunriseTime());
        assertEquals(1468158605, data.getSunsetTime());
        assertEquals(1468135130, data.getFetchTime());

        assertEquals(1, data.getWeather().size());
        assertEquals(WeatherType.RAIN, data.getWeather().get(0).getType());
    }

    @Test
    public void testVancouver() throws JSONException {
        WeatherData data = WeatherDataParser.JsonWeatherParse(SampleData.VAN_WEATHER_DATA);
        assertEquals(287.2, data.getTemperature(), Math.pow(10, -3));
        assertEquals(289.15, data.getTemperatureMax(), Math.pow(10, -3));
        assertEquals(285.15, data.getTemperatureMin(), Math.pow(10, -3));

        assertEquals(2.6, data.getWindSpeed(), Math.pow(10, -3));
        assertEquals(60, data.getWindOrientation());

        assertEquals(1016, data.getPressure(), Math.pow(10, -3));
        assertEquals(-1.0, data.getGrndPressure(), Math.pow(10, -3));
        assertEquals(-1.0, data.getSeaPressure(), Math.pow(10, -3));

        assertEquals(72, data.getHumidity());
        assertEquals(75, data.getCloudiness());
        assertEquals(-1.0, data.getRainVol()); //Default Values
        assertEquals(-1.0, data.getSnowVol()); //Default Values

        assertEquals(1468153155, data.getSunriseTime());
        assertEquals(1468210572, data.getSunsetTime());
        assertEquals(1468135606, data.getFetchTime());

        assertEquals(2, data.getWeather().size());
        assertEquals(WeatherType.RAIN, data.getWeather().get(0).getType());
        assertEquals(WeatherType.ATMOSPHERE, data.getWeather().get(1).getType());
    }
}
