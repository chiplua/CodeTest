package com.chiplua.turkey;

import java.util.Random;

/**
 * Created by chiplua on 15-7-2.
 */
public class DuckAdapter implements Turkey {
    Duck duck;
    Random rand;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random();
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        if (rand.nextInt(5)  == 0) {
            duck.fly();
        }
    }
}
