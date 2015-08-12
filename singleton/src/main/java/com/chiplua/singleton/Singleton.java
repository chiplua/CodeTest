package com.chiplua.singleton;

/**
 * Created by chiplua on 15-6-30.
 */
public class Singleton {
    private static Singleton uniqueInstance;

    public Singleton() {}

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
