package com.chiplua.compound;

/**
 * Created by chiplua_client on 15-7-7.
 */
public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
