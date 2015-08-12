package com.chiplua.compound;

/**
 * Created by chiplua on 15-7-7.
 */
public class Quackologist implements Observer {
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }

    public String toString() {
        return "Quackologist";
    }
}
