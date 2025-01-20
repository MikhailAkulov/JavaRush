package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт

Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        int max = 0;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (data > max) {
                    max = data;
                }
            }
        }
        System.out.println(max);
    }
}
