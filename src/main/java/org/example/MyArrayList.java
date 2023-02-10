package org.example;

public interface MyArrayList<E> {

    boolean add(E e);

    void add(int index, E e);

    boolean contains(Object o);

    E get(int index);

    E remove(int index);

    Object[] toArray();

    int size();

}
