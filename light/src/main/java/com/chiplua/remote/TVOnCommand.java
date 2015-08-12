package com.chiplua.party;

import com.chiplua.undo.Command;
import com.chiplua.remote.TV;
/**
 * Created by chiplua on 15-7-1.
 */
public class TVOnCommand implements Command {
    TV tv;

    public TVOnCommand(TV tv) {
        this.tv= tv;
    }

    @Override
    public void execute() {
        tv.on();
        tv.setInputChannel();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
