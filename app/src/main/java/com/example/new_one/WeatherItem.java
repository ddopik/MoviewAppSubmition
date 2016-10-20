package com.example.new_one;

/**
 * Created by ddopik on 10/19/2016.
 */

public class WeatherItem {

    private int id;
    private int minTemp;
    private int maxTemp;
    private String weatherMainType;
    private String weatherDescription;


    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getWeatherMainType() {
        return weatherMainType;
    }

    public void setWeatherMainType(String weatherMainType) {
        this.weatherMainType = weatherMainType;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
