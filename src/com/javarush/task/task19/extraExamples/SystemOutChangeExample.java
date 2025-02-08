package com.javarush.task.task19.extraExamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SystemOutChangeExample {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream filePrintStream = new PrintStream(new File("C:\\Users\\Akulo\\Desktop\\testFile.txt"));

        // Сохраним текущее значение System.out в отдельную переменную,
        // чтобы потом можно было переключиться обратно на вывод в консоль
        PrintStream console = System.out;

        // Присваиваем System.out новое значение
        System.setOut(filePrintStream);
        System.out.println("Эта строка будет записана в текстовый файл");

        // Возвращаем System.out старое значение
        System.setOut(console);
        System.out.println("А эта строка - в консоль!");
    }
}
