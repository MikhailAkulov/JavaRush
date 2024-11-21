package com.javarush.task.pro.task13.task1314;

import javax.swing.*;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public StringLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void add(String value) {
        Node newNode = new Node();
        newNode.value = value;

        Node prevLast = last.prev;
        prevLast.next = newNode;
        newNode.prev = prevLast;
        newNode.next = last;
        last.prev = newNode;
    }

    public String get(int index) {
        Node currentElement = first.next;
        for (int i = 0; (currentElement != null) && (currentElement != last) ; i++) {
            if (i == index) {
                String str = currentElement.value;
                return str;
            } else {
                currentElement = currentElement.next;
            }
        }
        return null;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
