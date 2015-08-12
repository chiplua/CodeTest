package com.chiplua.undo;

/**
 * Created by chiplua on 15-7-1.
 */
public class DimmerLightOnCommand implements Command {
    Light light;
    int prevLevel;

    public DimmerLightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        prevLevel = light.getLevel();
        light.dim(75);
    }

    @Override
    public void undo() {
        light.dim(prevLevel);
    }
}
