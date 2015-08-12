package com.chiplua.singleton;

/**
 * Created by chiplua on 15-7-1.
 */
public class SingletonTestDrive {
    public static void main(String[] args) {
        Singleton foo = CoolerSingleton.getInstance();
        Singleton bar = HotterSingleton.getInstance();
        System.out.println(foo + " foo");
        System.out.println(bar + " bar");
    }
}
