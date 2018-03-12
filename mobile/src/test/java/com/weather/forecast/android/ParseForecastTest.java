package com.weather.forecast.android;

import com.weather.forecast.android.data.WeatherData;
import com.weather.forecast.android.parsers.WeatherDataParser;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ParseForecastTest {
    @Test
    public void testMumbai() {
        List<WeatherData> data = WeatherDataParser.JsonForecastParse(SampleData.MUM_FORECAST_DATA);
        assertEquals(38, data.size());
        for (int i = 0; i < data.size() - 1; i++) {
            // Fetched every 3 minutes
            assertEquals(10800, Math.abs(data.get(i).getFetchTime() - data.get(i + 1).getFetchTime()));
        }
    }
}
