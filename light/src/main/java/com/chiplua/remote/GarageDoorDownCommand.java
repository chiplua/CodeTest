package com.chiplua.remote;

import com.chiplua.undo.Command;
import com.chiplua.light.GarageDoor;
/**
 * Created by chiplua on 15-7-1.
 */
public class GarageDoorDownCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {

    }
}
