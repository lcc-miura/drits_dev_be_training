package org.example;

public class Node<E> {

    Node<E> next = null;
    E data;

    public Node(E newData) {
        data = newData;
    }
}
