package com.javarush.task.task19.extraExamples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Можно считывать данные из файла, передав путь к нему:
 */
public class FileReaderExample {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\testFile.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
        reader.close();
    }
}
