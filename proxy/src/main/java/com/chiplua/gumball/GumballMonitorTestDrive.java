package com.chiplua.gumball;

import com.chiplua.gumballmonitor.GumballMonitor;

import java.rmi.Naming;
/**
 * Created by chiplua on 15-7-7.
 */
public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String[] location = {
                "rmi://127.0.0.1/gumballmachine",
                "rmi://192.168.3.122/gumballmachine"
                             /*"rmi://santafe.mightygumball.com/gumballmachine",
                             "rmi://boulder.mightygumball.com/gumballmachine",
                             "rmi://seattle.mightygumball.com/gumballmachine"*/};

        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                System.out.println(location[i]);
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < monitor.length; i++) {
            monitor[i].report();
        }
    }
}
