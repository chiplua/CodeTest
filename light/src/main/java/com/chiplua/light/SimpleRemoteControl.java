package com.chiplua.light;

import com.chiplua.undo.Command;
/**
 * Created by chiplua on 15-7-1.
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
