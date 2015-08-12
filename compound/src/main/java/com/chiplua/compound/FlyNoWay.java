package com.chiplua.compound;

/**
 * Created by chiplua on 15-7-8.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
