package com.chiplua.duck;

public class MallarDuck extends Duck{
    public MallarDuck(){
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'am a real Mallard duck!!");
    }

    public void nameGet(){
		System.out.println("My name is MallarDuck!!");
    }

}
