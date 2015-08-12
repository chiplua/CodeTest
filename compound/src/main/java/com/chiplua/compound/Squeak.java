package com.chiplua.compound;

/**
 * Created by chiplua on 15-7-8.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
