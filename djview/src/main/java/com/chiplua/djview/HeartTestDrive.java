package com.chiplua.djview;

/**
 * Created by chiplua on 15-7-8.
 */
public class HeartTestDrive {
    public static void main (String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
