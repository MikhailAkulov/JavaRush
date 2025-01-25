package com.javarush.task.task18.extraExamples;

import java.io.FileInputStream;
import java.io.IOException;

// Чтение байтов из файла

public class FileInputStreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile.txt");

        int i;

        while ((i=fileInputStream.read()) != -1) {
            System.out.print((char)i);
        }
    }
}
