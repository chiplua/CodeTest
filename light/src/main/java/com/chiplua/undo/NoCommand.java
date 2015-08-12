package com.chiplua.undo;

/**
 * Created by chiplua on 15-7-1.
 */
public class NoCommand implements Command {
    @Override
    public void execute() {}

    @Override
    public void undo() {}
}
