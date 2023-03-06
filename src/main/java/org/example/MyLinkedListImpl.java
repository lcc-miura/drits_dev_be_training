package org.example;

import java.util.Objects;

public class MyLinkedListImpl<E> implements MyList<E> {
    private Node<E> head;
    private int size = 0;

    public MyLinkedListImpl() {
        head = new Node<E>(null);
    }

    private void addLast(E data) {
        Node<E> n = head;
        while(n.next != null) {
            n = n.next;
        }
        n.next = new Node<>(data);
    }

    private Node<E> getNodeOfBeforeIndex(int n) {
        var node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        return node;
    }

    private void validateAccessOfIndex(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
    }


    public boolean add(E e) {
        addLast(e);
        size++;
        return true;
    }

    public void add(int index, E e) {
        validateAccessOfIndex(index);

        var newNode = new Node<>(e);
        var beforeIndexNode = getNodeOfBeforeIndex(index);

        newNode.next = beforeIndexNode.next;
        beforeIndexNode.next = newNode;

        size++;
    }

    public boolean contains(Object o) {
        var node = head.next;

        for (int i = 0; i < size; i++) {
            if( Objects.equals(node.data, o) ) return true;
            node = node.next;
        }

        return false;
    }

    public E get(int index) {
        validateAccessOfIndex(index);
        return getNodeOfBeforeIndex(index).next.data;
    }

    public E remove(int index) {
        validateAccessOfIndex(index);

        var beforeIndexNode = getNodeOfBeforeIndex(index);
        var indexNode = beforeIndexNode.next;
        beforeIndexNode.next = indexNode.next;

        size--;

        return indexNode.data;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];

        var node = head.next;

        for (int i = 0; i < size; i++) {
            array[i] = node.data;
            node = node.next;
        }

        return array;
    }

    public int size() {
        return size;
    }
}
