package com.chiplua.remote;

import com.chiplua.undo.Command;
import com.chiplua.undo.Light;
/**
 * Created by chiplua on 15-7-1.
 */
public class LivingroomLightOnCommand implements Command {
    Light light;

    public LivingroomLightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {

    }
}
