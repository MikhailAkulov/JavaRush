package com.javarush.task.task19.extraExamples;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Копируем файл на диске
 */
public class CopyFileExample {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\Users\\Akulo\\Desktop\\testFile.txt");
        FileWriter writer = new FileWriter("C:\\Users\\Akulo\\Desktop\\testFileCopy.txt");

        while (reader.ready()) {            // пока есть непрочитанные байты в потоке ввода
            int data = reader.read();       // читаем один символ (char будет расширен до int)
            writer.write(data);             // пишем один символ (int будет обрезан/сужен до char)
        }

        // закрываем потоки после использования
        reader.close();
        writer.close();
    }
}
