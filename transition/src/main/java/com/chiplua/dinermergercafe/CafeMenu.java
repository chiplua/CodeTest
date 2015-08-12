package com.chiplua.dinermergercafe;

import com.chiplua.transition.Menu;
import com.chiplua.transition.MenuItem;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by chiplua on 15-7-6.
 */
public class CafeMenu implements Menu {
    Hashtable menuItems = new Hashtable();

    public CafeMenu() {
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    public Hashtable getItems() {
        return menuItems;
    }

    @Override
    public Iterator createIterator() {
        return (Iterator)menuItems.values().iterator();
    }
}
