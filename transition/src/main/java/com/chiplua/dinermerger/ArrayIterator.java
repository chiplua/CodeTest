package com.chiplua.dinermerger;

import com.chiplua.transition.MenuItem;
/**
 * Created by chiplua on 15-7-6.
 */
public class ArrayIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public ArrayIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}
