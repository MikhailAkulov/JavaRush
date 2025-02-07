package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст

Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить весь текст и на консоль и в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String sourceStr = outputStream.toString();
        System.setOut(consoleStream);

        // не понравилось валидатору
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))){
//            fileWriter.write(sourceStr);
//        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            fileOutputStream.write(sourceStr.getBytes());
        }
        System.out.println(sourceStr);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile1915.txt