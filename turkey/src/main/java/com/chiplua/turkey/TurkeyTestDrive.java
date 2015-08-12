package com.chiplua.turkey;

/**
 * Created by chiplua on 15-7-2.
 */
public class TurkeyTestDrive {
    public static void main(String[] args) {
        MallarDuck duck = new MallarDuck();
        Turkey duckAdapter = new DuckAdapter(duck);

        for(int i=0; i<10; i++) {
            System.out.println("The DuckAdapter says...");
            duckAdapter.gobble();
            duckAdapter.fly();
            System.out.println("\n");
        }
    }
}
