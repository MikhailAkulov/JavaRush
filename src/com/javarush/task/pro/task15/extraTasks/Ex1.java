package com.javarush.task.pro.task15.extraTasks;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Проверка сколько займет чтение файла и вывод в консоль в миллисекундах с использованием FileInputStream и
 * BufferedInputStream
 */
public class Ex1 {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\123.pdf");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int i;

        //  С BufferedInputStream (Время = 1785 м.с.)
        while ((i = bufferedInputStream.read()) != -1) {
            System.out.print((char) i);
        }

        //  Без BufferedInputStream (Время = 3008 м.с.)
//        while ((i = fileInputStream.read()) != -1) {
//            System.out.print((char) i);
//        }

        Date date1 = new Date();

        System.out.println("Время = " + (date1.getTime() - date.getTime()) + " м.с.");
    }
}
