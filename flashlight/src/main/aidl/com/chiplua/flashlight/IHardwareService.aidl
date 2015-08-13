// IHardwareService.aidl
package com.chiplua.flashlight;

// Declare any non-default types here with import statements

interface IHardwareService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    boolean getFlashlightEnabled();
    void setFlashlightEnabled(boolean on);
}
