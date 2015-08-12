package com.chiplua.duck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
		MallarDuck mallard  = new MallarDuck();
		mallard.performQuack();
		mallard.performFly();
		mallard.display();
		mallard.nameGet();

		ModelDuck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
    }
}
