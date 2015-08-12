package com.chiplua.remote;

import com.chiplua.undo.Command;
import com.chiplua.light.GarageDoor;
/**
 * Created by chiplua on 15-7-1.
 */
public class GarageDoorUpCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {

    }
}
