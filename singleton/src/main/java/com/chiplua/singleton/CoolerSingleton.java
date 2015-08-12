package com.chiplua.singleton;

/**
 * Created by chiplua on 15-7-1.
 */
public class CoolerSingleton extends Singleton {
    protected static Singleton uniqueInstance;

    private CoolerSingleton() {
        super();
    }
}
