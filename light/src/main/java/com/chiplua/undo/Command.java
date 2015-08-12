package com.chiplua.undo;

/**
 * Created by chiplua on 15-7-1.
 */
public interface Command {
    public void execute();
    public void undo();
}
