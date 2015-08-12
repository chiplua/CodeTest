package com.chiplua.remote;

import com.chiplua.undo.Command;
/**
 * Created by chiplua on 15-7-1.
 */
public class HottubOffCommand implements Command {
    Hottub hottub;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.cool();
        hottub.off();
    }

    @Override
    public void undo() {

    }
}
