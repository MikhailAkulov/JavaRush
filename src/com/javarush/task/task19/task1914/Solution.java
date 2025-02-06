package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример

В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c Отрицательных и дробных чисел, унарных операторов - нет.
Пример вывода: 3 + 6 = 9
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String sourceStr = outputStream.toString();
        System.setOut(consoleStream);

        String[] strArray = sourceStr.trim().split(" ");
        int a = Integer.parseInt(strArray[0].trim());
        int b = Integer.parseInt(strArray[2].trim());
        String sign = strArray[1].trim();
        int result = 0;
        switch (sign) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
        }
        String resultStr = sourceStr.replaceAll("\r\n", "");
        System.out.println(resultStr + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

