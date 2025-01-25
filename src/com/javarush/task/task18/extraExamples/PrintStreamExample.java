package com.javarush.task.task18.extraExamples;

import java.io.*;

public class PrintStreamExample {
    private static final String GREETINGS_MESSAGE = "My name is %s, my age is %d!";

    public static void main(String[] args) throws IOException {
        /**
         * Этот код создаст на рабочем столе файл test.txt (если он там еще не существует) и запишет туда
         * последовательно наши число, строку и boolean-переменную.
         */
//        PrintStream filePrintStream = new PrintStream(new File("C:\\Users\\Akulo\\Desktop\\testFile2.txt"));
        // или просто
//        PrintStream filePrintStream = new PrintStream("C:\\Users\\Akulo\\Desktop\\testFile2.txt");
//        filePrintStream.println(222);
//        filePrintStream.println("Hello world!");
//        filePrintStream.println(false);

        /**
         * Форматированная строка
         */
//        PrintStream printStream = new PrintStream("C:\\Users\\Akulo\\Desktop\\testFile2.txt");
//        printStream.println("Hello");
//        printStream.println("I'm robot!");
//        printStream.printf("My name is %s, my age is %d!", "Bender", 4);
//        printStream.close();

        /**
         * Форматированная строка 2 пример
         */
//        PrintStream printStream2 = new PrintStream("C:\\Users\\Akulo\\Desktop\\testFile2.txt");
//        printStream2.println("Hello!");
//        printStream2.println("We are robots!");
//        printStream2.printf(GREETINGS_MESSAGE, "Bender", 4);
//        printStream2.printf("\n" + GREETINGS_MESSAGE, "R2-D2", 256);
//        printStream2.printf("\n" + GREETINGS_MESSAGE, "C-3PO", 128);
//        printStream2.close();

        /**
         * Подмена System.in
         */
        String greetings = "Привет! Меня зовут Бендер!\nЯ изучаю Java на сайте JavaRush.\nОднажды я стану крутым программистом!\n";
        byte[] bytes = greetings.getBytes();

        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
    }
}
