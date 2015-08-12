package com.chiplua.pizzafm;

import com.chiplua.pizzas.Pizza;
/**
 * Created by chiplua on 15-6-29.
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
