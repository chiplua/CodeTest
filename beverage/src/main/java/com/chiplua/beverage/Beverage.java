package com.chiplua.beverage;

/**
 * Created by chiplua on 15-6-19.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
