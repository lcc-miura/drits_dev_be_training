package org.example;

import java.util.Arrays;

public class MyArrayListImpl<E> implements MyArrayList<E>{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(E e) {
        if(size == elements.length) { ensureCapacity(); }
        elements[size++] = e;
        return true;
    };

    public void add(int index, E e) {
        elements[index] = e;
    };

    public boolean contains(Object o) {
        return Arrays.stream(elements)
            .filter(el -> {
                if(el == null) {return false;}
                return el.equals(o);
            })
            .map(el -> true)
            .findFirst().orElse(false);
    };

    public E get(int index) {
        return (E) elements[index];
    };

    public E remove(int index) {
        E val = (E)elements[index];
        elements[index] = null;
        return val;
    };

    public Object[] toArray() {
        return elements;
    };

    public int size() {
        return elements.length;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
