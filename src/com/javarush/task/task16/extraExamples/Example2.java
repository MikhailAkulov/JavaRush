package com.javarush.task.task16.extraExamples;

/**
 * Метод Thread.sleep()
 * Один важный нюанс: поток в состоянии сна можно прервать.
 * В таком случае в программе возникнет исключение InterruptedException
 */
public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(3000);

        System.out.println(" - Сколько я проспал? \n - " + ((System.currentTimeMillis()-start)) / 1000 + " секунды");
    }
}
