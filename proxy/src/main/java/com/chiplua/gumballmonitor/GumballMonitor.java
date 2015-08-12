package com.chiplua.gumballmonitor;

import com.chiplua.gumball.GumballMachineRemote;

import java.rmi.RemoteException;

/**
 * Created by chiplua on 15-7-7.
 */
public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
            System.out.println("Current state: " + machine.getState());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
