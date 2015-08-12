package com.chiplua.weather;

import com.chiplua.weather.Observer;

/**
 * Created by chiplua on 15-6-18.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
