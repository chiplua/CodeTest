package com.chiplua.iterenum;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by chiplua on 15-7-2.
 */
public class EnumerationIteratorTestDrive {
    public static void main (String args[]) {
        Vector v = new Vector(Arrays.asList(args));
        Iterator iterator = new EnumerationIterator(v.elements());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
