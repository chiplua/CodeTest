package com.chiplua.dinermerger;

import java.util.ArrayList;
/**
 * Created by chiplua on 15-7-6.
 */
public class ArrayListIterator implements Iterator {
    ArrayList items;
    int position = 0;

    public ArrayListIterator(ArrayList items) {
        this.items = items;
    }

    @Override
    public Object next() {
        Object object = items.get(position);
        position = position + 1;
        return object;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        } else {
            return true;
        }
    }
}
