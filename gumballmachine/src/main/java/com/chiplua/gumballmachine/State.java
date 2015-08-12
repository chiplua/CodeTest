package com.chiplua.gumballmachine;

/**
 * Created by chiplua on 15-7-7.
 */
public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
