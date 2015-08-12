package com.chiplua.compound;

/**
 * Created by chiplua on 15-7-7.
 */
public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return null;
        //return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return null;
        //return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return null;
        //return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return null;
        //return new QuackCounter(new RubberDuck());
    }
}
