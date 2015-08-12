package com.chiplua.duck;

/**
 * Created by chiplua_client on 15-6-17.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'am flying with a rocket!!");
    }
}
