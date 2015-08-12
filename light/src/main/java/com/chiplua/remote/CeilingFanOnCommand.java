package com.chiplua.remote;

import com.chiplua.undo.Command;
import com.chiplua.undo.CeilingFan;
/**
 * Created by chiplua on 15-7-1.
 */
public class CeilingFanOnCommand implements Command {
    CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.high();
    }

    @Override
    public void undo() {

    }
}
