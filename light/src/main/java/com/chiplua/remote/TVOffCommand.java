package com.chiplua.party;

import com.chiplua.undo.Command;
import com.chiplua.remote.TV;
/**
 * Created by chiplua on 15-7-1.
 */
public class TVOffCommand implements Command {
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv= tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
