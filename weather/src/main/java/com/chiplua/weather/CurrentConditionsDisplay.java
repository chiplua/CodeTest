package com.chiplua.weather;

import com.chiplua.weather.Observer;
import com.chiplua.weather.Subject;
import com.chiplua.weather.DisplayElement;
import com.chiplua.weather.WeatherData;

/**
 * Created by chiplua on 15-6-18.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degress and " + humidity + "% humidity");
    }
}
