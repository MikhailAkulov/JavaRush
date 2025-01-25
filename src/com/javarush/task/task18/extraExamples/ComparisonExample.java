package com.javarush.task.task18.extraExamples;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

// Сравниение по времени чтение байтов из файла с использованием буффера и без
public class ComparisonExample {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile2.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int i;
//        while ((i = bufferedInputStream.read()) != -1) {
//            System.out.print((char) i);
//        }
//        Date date1 = new Date();
//        System.out.println("\nWith buffer = " + (date1.getTime() - date.getTime()));

        Date date2 = new Date();
        while ((i = fileInputStream.read()) != -1) {
            System.out.print((char) i);
        }
        Date date3 = new Date();
        System.out.println("\nWithout buffer = " + (date3.getTime() - date2.getTime()));
    }
}
