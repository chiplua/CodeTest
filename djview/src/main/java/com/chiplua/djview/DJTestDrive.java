package com.chiplua.djview;

/**
 * Created by chiplua on 15-7-8
 */
public class DJTestDrive {
    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
