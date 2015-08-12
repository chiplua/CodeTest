package com.chiplua.weather;

/**
 * Created by chiplua on 15-6-18.
 */
public interface Observer {
    public void update(float temperature, float humidity, float pressure);
}
