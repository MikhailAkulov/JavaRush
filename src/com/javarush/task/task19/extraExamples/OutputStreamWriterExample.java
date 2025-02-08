package com.javarush.task.task19.extraExamples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Есть класс OutputStream, который умеет записывать только байты;
 * есть абстрактный класс Writer, который умеет работать с символами, и есть два несовместимых интерфейса.
 *
 * Эту проблему успешно решает паттерн Адаптер.
 * При помощи класса OutputStreamWriter мы легко «адаптируем» два интерфейса классов Writer и OutputStream друг другу.
 * И, получив байтовый поток OutputStream в конструктор, с помощью OutputStreamWriter мы
 * можем записывать символы (записали в наш файл символ с кодом 32144 — 綐)
 */
public class OutputStreamWriterExample {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Akulo\\Desktop\\testFile.txt"));
        streamWriter.write(32144);
        streamWriter.close();
    }
}
