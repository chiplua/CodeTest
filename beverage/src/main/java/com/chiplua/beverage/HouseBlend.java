package com.chiplua.beverage;

/**
 * Created by chiplua on 15-6-23.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee:";
    }

    @Override
    public double cost() {
        return 0.27;
    }
}
