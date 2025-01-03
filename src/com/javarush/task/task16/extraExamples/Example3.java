package com.javarush.task.task16.extraExamples;

/**
 * Метод Thread.join()
 */
public class Example3 {
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample();
        ThreadExample t2 = new ThreadExample();

        t1.start();

        /*Второй поток t2 начнет выполнение только после того, как будет завершен
       (или бросит исключение) первый поток - t1*/

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        //Главный поток продолжит работу только после того, как t1 и t2 завершат работу

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все потоки закочили работу, прогшрамма завершена.");
    }
}

class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Начало работы потока " + getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток " + getName() + " завершил работу.");
    }
}