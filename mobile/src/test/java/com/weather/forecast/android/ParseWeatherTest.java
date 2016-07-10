package com.weather.forecast.android;

import com.weather.forecast.android.data.Weather;
import com.weather.forecast.android.data.WeatherData;
import com.weather.forecast.android.parsers.JSONParsers;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Prayansh on 16-07-10.
 */
public class ParseWeatherTest {
    @Test
    public void testMumbai() {
        WeatherData data = JSONParsers.JSONWeatherParse(SampleData.MUM_WEATHER_DATA);
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
        assertEquals(-1, data.getSnowVol());
        assertEquals(-1, data.getVisibility());

        assertEquals(1468111074, data.getSunriseTime());
        assertEquals(1468158605, data.getSunsetTime());
        assertEquals(1468135130, data.getFetchTime());

        assertTrue("moderate rain".equalsIgnoreCase(data.getWeather().getDesc()));
        assertTrue("RAIN".equalsIgnoreCase(data.getWeather().getStat().name()));
    }

    @Test
    public void testVancouver() {
        WeatherData data = JSONParsers.JSONWeatherParse(SampleData.VAN_WEATHER_DATA);
        //TODO Pavan design test for vancouver weather data
        //USe top for reference
    }
}
