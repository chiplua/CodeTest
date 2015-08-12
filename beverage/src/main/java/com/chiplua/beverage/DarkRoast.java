package com.chiplua.beverage;

/**
 * Created by chiplua on 15-6-23.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee:";
    }

    @Override
    public double cost() {
        return 0.11;
    }
}
