package com.javarush.task.task19.extraExamples;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Ридер-обертка на System.out
 */
public class OutputStreamWrapperExample {
    public static void main(String[] args) {
        PrintStream consoleStream = System.out;     // запоминаем настоящий PrintStream в специальную переменную

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();       // Создаем динамический массив

        PrintStream stream = new PrintStream(outputStream);     // создаем адаптер к классу PrintStream

        System.setOut(stream);      // Устанавливаем его как текущий System.out

        printSomething();       // Вызываем функцию, которая ничего не знает о наших манипуляциях

        String result = outputStream.toString();        // Преобразовываем записанные в наш ByteArray данные в строку

        System.setOut(consoleStream);       // Возвращаем все как было

        System.out.println(result);     // выводим строку в консоль

        // разворачиваем строку
        StringBuilder stringBuilder = new StringBuilder(result);
        stringBuilder.reverse();
        String reverseString = stringBuilder.toString();

        System.out.println(reverseString);      // выводим ее в консоль
    }

    public static void printSomething() {
        System.out.println("Hi");
        System.out.println("My name is Slim Shady");
        System.out.println("Bye-bye!");
    }
}
