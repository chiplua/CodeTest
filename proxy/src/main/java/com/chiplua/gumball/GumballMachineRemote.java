package com.chiplua.gumball;

import com.chiplua.state.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by chiplua on 15-7-7.
 */
public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
