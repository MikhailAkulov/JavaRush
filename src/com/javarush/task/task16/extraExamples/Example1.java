package com.javarush.task.task16.extraExamples;

/**
 * Создание и запуск 10 потоков
 */
public class Example1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyFirstThread thread = new MyFirstThread();
            thread.start();
        }
    }
}

class MyFirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm Thread! My name is " + getName());
    }
}
