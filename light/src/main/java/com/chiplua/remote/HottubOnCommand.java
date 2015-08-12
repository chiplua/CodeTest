package com.chiplua.remote;

import com.chiplua.undo.Command;
/**
 * Created by chiplua on 15-7-1.
 */
public class HottubOnCommand implements Command {
    Hottub hottub;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.on();
        hottub.heat();
        hottub.bubblesOn();
    }

    @Override
    public void undo() {

    }
}
