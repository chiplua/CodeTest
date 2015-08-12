package com.chiplua.gumball;

import com.chiplua.gumballmonitor.GumballMachine;
import com.chiplua.gumballmonitor.GumballMonitor;

import java.rmi.Naming;

/**
 * Created by chiplua on 15-7-16.
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        int count = 0;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);

            gumballMachine = new GumballMachine(args[0], count);
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
            GumballMonitor monitor = new GumballMonitor(gumballMachine);
            monitor.report();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
