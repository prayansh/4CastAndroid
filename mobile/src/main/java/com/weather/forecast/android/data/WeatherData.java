package com.weather.forecast.android.data;

/**
 * Created by Prayansh on 16-07-10.
 */
public class WeatherData {
    private double temperature, temperatureMin, temperatureMax;
    private double pressure, seaPressure, grndPressure;
    private int humidity;
    private long visibility;
    private double windSpeed;
    private int windOrientation;
    private int cloudiness;
    private long sunriseTime, sunsetTime, fetchTime;
    private double rainVol, snowVol;
    private Weather weather;

    public WeatherData(double temperature, double temperatureMin, double temperatureMax,
                       double pressure, double seaPressure, double grndPressure, int humidity,
                       long visibility, double windSpeed, int windOrientation, int cloudiness, long sunriseTime, long sunsetTime, long fetchTime,
                       double rainVol, double snowVol, Weather weather) {
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.pressure = pressure;
        this.seaPressure = seaPressure;
        this.grndPressure = grndPressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windOrientation = windOrientation;
        this.cloudiness = cloudiness;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.fetchTime = fetchTime;
        this.rainVol = rainVol;
        this.snowVol = snowVol;
        this.weather = weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public double getPressure() {
        return pressure;
    }

    public double getSeaPressure() {
        return seaPressure;
    }

    public double getGrndPressure() {
        return grndPressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public long getVisibility() {
        return visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getWindOrientation() {
        return windOrientation;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public long getSunriseTime() {
        return sunriseTime;
    }

    public long getSunsetTime() {
        return sunsetTime;
    }

    public long getFetchTime() {
        return fetchTime;
    }

    public double getRainVol() {
        return rainVol;
    }

    public double getSnowVol() {
        return snowVol;
    }

    public Weather getWeather() {
        return weather;
    }

    public String getWeatherDescription() {
        return weather.getDesc();
    }


    public WeatherType getWeatherType(){
        return weather.getType();
    }
}
