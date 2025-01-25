package com.javarush.task.task18.extraExamples;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

// Чтение с использованием буффера

public class BufferedInputStreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile.txt");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);

        int i;

        while ((i=bufferedInputStream.read()) != -1) {
            System.out.print((char)i);
        }
    }
}
