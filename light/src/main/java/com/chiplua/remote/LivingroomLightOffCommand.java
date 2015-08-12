package com.chiplua.remote;

import com.chiplua.undo.Command;
import com.chiplua.undo.Light;
/**
 * Created by chiplua on 15-7-1.
 */
public class LivingroomLightOffCommand implements Command {
    Light light;

    public LivingroomLightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {

    }
}
