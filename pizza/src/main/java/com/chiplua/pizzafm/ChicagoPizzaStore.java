package com.chiplua.pizzafm;

import com.chiplua.pizzas.Pizza;
import com.chiplua.pizzas.PizzaStore;
import com.chiplua.pizzas.SimplePizzaFactory;

/**
 * Created by chiplua on 15-6-29.
 */
public class ChicagoPizzaStore extends PizzaStore {
	public ChicagoPizzaStore(SimplePizzaFactory factory) {
		super(factory);
	}

	Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
