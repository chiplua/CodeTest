package com.chiplua.djview;

/**
 * Created by chiplua on 15-7-8.
 */
public interface ControllerInterface {
    void start();
    void stop();
    void increaseBPM();
    void decreaseBPM();
    void setBPM(int bpm);
}
