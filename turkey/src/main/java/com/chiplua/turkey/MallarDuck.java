package com.chiplua.turkey;

public class MallarDuck implements Duck{
    @Override
    public void display() {
        System.out.println("I'am a real Mallard duck!!");
    }

    public void nameGet(){
		System.out.println("My name is MallarDuck!!");
    }

    @Override
    public void quack() {
        System.out.println("My name is MallarDuck, I can quack!!");
    }

    @Override
    public void fly() {
        System.out.println("My name is MallarDuck, I can fly!!");
    }
}
