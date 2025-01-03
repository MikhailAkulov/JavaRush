package com.javarush.task.task16.extraExamples;

/**
 * Метод Thread.interrupt()
 * если у потока вызвать метод interrupt(), есть 2 варианта:
 * 1. Если объект находился в этот момент в состоянии ожидания, например, join или sleep, ожидание будет прервано,
 * и программа выбросит InterruptedException.
 * 2. Если же поток в этот момент был в работоспособном состоянии, у объекта будет установлен boolean-флаг interrupted.
 * Но проверить объект на значение этого флага и корректно завершить работу мы должны будем самостоятельно!
 * Для этого в классе Thread есть специальный метод — boolean isInterrupted().
 */
public class Example4 {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        clock.start();

        Thread.sleep(10000);
        clock.interrupt();
    }
}

class Clock extends Thread {
    @Override
    public void run() {
        Thread current = Thread.currentThread();

        while (!current.isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Работа потока была прервана");
                break;
            }
            System.out.println("Tik");
        }
    }
}