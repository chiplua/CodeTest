package com.chiplua.state;

import java.io.*;
/**
 * Created by chiplua on 15-7-7.
 */
public interface State extends Serializable {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}