package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Подсчет запятых

С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        // 1 вариант
//        List<Integer> sourceList = new ArrayList<>();
//        try (FileInputStream inputStream = new FileInputStream(fileName)){
//            while (inputStream.available() > 0) {
//                int data = inputStream.read();
//                sourceList.add(data);
//            }
//        }
//
//        char c = ',';
//        int count = 0;
//        for (Integer i : sourceList) {
//            if (i == (int) c) {
//                count++;
//            }
//        }
//        System.out.println(count);

        // 2 вариант
        int commaCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                if (fileInputStream.read() == 44) {
                    commaCount++;
                }
            }
        }
        System.out.println(commaCount);
        // C:\Users\Akulo\Desktop\SourceDirectory\pushkin.txt
    }
}
