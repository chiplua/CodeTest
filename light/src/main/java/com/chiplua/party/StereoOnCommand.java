package com.chiplua.light;

import com.chiplua.undo.Command;
import com.chiplua.remote.Stereo;
/**
 * Created by chiplua on 15-7-1.
 */
public class StereoOnCommand implements Command {
    Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
