package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити

В методе main добавить в статический объект list 5 нитей.
Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
//        SpecialThread specTh1 = new SpecialThread();
//        SpecialThread specTh2 = new SpecialThread();
//        SpecialThread specTh3 = new SpecialThread();
//        SpecialThread specTh4 = new SpecialThread();
//        SpecialThread specTh5 = new SpecialThread();
//        Thread thread1 = new Thread(specTh1);
//        Thread thread2 = new Thread(specTh2);
//        Thread thread3 = new Thread(specTh3);
//        Thread thread4 = new Thread(specTh4);
//        Thread thread5 = new Thread(specTh5);
//        list.add(thread1);
//        list.add(thread2);
//        list.add(thread3);
//        list.add(thread4);
//        list.add(thread5);

        //  или просто:
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
