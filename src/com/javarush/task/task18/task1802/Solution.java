package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт

Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bReader.readLine();

        int minByte = 255;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int currentByte = inputStream.read();
                if (currentByte < minByte) {
                    minByte = currentByte;
                }
            }
        }
        System.out.println(minByte);
    }
}
