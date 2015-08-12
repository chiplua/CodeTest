package com.chiplua.pizzafm;

import com.chiplua.pizzas.Pizza;
import com.chiplua.pizzas.PizzaStore;
import com.chiplua.pizzas.SimplePizzaFactory;

/**
 * Created by chiplua on 15-6-29.
 */
public class NYPizzaStore extends PizzaStore {
	public NYPizzaStore(SimplePizzaFactory factory) {
		super(factory);
	}

	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}
