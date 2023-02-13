package org.example;

import java.util.Arrays;

public class MyArrayListImpl<E> implements MyList<E>{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(E e) {
        if(size == elements.length) ensureCapacity();
        elements[size] = e;
        size++;
        return true;
    }

    public void add(int index, E e) throws ArrayIndexOutOfBoundsException {
        if(size == elements.length) ensureCapacity();

        Object[] behindIndexList = Arrays.copyOfRange(elements, index, size);
        elements[index] = e;

        System.arraycopy(behindIndexList, 0, elements, index + 1, behindIndexList.length);

        size++;
    }

    public boolean contains(Object o) {
        return Arrays.stream(elements)
            .filter(el -> {
                if(el == null) return false;
                return el.equals(o);
            })
            .map(el -> true)
            .findFirst().orElse(false);
    }

    public E get(int index) throws ArrayIndexOutOfBoundsException {
        return (E) elements[index];
    }

    public E remove(int index) throws ArrayIndexOutOfBoundsException {
        var val = (E)elements[index];

        var newList = new Object[elements.length];
        var beforeIndexList = Arrays.copyOfRange(elements, 0, index);
        var afterIndexList = Arrays.copyOfRange(elements, index + 1, size);
        System.arraycopy(beforeIndexList, 0, newList, 0, beforeIndexList.length);
        System.arraycopy(afterIndexList, 0, newList, index, afterIndexList.length);

        size--;
        this.elements = newList;
        return val;
    }

    public Object[] toArray() {
        return Arrays.copyOfRange(elements, 0, size);
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        var newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
