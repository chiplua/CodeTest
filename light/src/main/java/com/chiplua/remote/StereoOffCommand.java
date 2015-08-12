package com.chiplua.remote;

import com.chiplua.undo.Command;
/**
 * Created by chiplua on 15-7-1.
 */
public class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {

    }
}
