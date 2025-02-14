package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама

В методе main подмени объект System.out написанной тобой ридер-оберткой.
Твоя ридер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        String[] strArray = result.split("\\n");
        String text = "JavaRush - курсы Java онлайн";
        int i = 1;
        for (String word : strArray) {
            if (i % 2 != 0) {
                System.out.println(word);
            } else {
                System.out.println(word);
                System.out.println(text);
            }
            i++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
