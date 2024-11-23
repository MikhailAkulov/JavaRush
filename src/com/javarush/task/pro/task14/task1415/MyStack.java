package com.javarush.task.pro.task14.task1415;

import java.util.LinkedList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new LinkedList<>();

    public void push(String s) {
        storage.add(0, s);
    }

    public String pop() {
//        String str = String.valueOf(storage.get(0));
//        storage.remove(0);
//        return str;
        return storage.remove(0);
    }

    public String peek() {
//        String str = String.valueOf(storage.get(0));
//        return str;
        return storage.get(0);
    }

    public boolean empty() {
//        if (storage.isEmpty()) {
//            return true;
//        } else
//            return false;
        return storage.isEmpty();
    }

    public int search(String s) {
//        for (String el: storage) {
//            if (el.equals(s)) {
//                return storage.indexOf(el);
//            }
//        }
//        return -1;
        return storage.indexOf(s);
    }

//    public static void main(String[] args) {
//        MyStack myStack = new MyStack();
//        myStack.push("1");
//        myStack.push("2");
//        myStack.push("3");
//        myStack.push("4");
//        myStack.push("5");
//        System.out.println(myStack.storage);
//        System.out.println(myStack.pop());
//        System.out.println(myStack.storage);
//        System.out.println(myStack.peek());
//        System.out.println(myStack.storage);
//        System.out.println(myStack.empty());
//    }
}
