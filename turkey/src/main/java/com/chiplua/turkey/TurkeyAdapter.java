package com.chiplua.turkey;

/**
 * Created by chiplua on 15-7-2.
 */
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for(int i=0; i < 5; i++) {
            turkey.fly();
        }
    }

    @Override
    public void display() {}
}