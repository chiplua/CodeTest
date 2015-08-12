package com.chiplua.iterator;

import java.util.Iterator;
/**
 * Created by chiplua on 15-7-7.
 */
public class NullIterator implements Iterator {
    @Override
    public Object next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}