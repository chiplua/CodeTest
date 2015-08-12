package com.chiplua.beverage;

/**
 * Created by chiplua on 15-6-23.
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
