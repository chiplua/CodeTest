package com.chiplua.beverage;

/**
 * Created by chiplua_client on 15-6-23.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.33 + beverage.cost();
    }
}
