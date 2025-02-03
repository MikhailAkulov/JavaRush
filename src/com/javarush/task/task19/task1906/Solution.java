package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы

Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie

Закрыть потоки ввода-вывод
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1 вариант
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = reader.readLine();
//        String fileName2 = reader.readLine();
//        reader.close();
//
//        try (FileReader fileReader = new FileReader(fileName1);
//             FileWriter fileWriter = new FileWriter(fileName2)) {
//            for (int i = 1; fileReader.ready(); i++) {
//                int data = fileReader.read();
//                if (i % 2 == 0) {
//                    fileWriter.write(data);
//                }
//            }
//        }

        // 2 вариант
        String fileName1;
        String fileName2;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        try (FileReader fileReader = new FileReader(fileName1)) {
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            for (int i = 1; i < list.size(); i = i + 2) {
                fileWriter.write((byte) (int) list.get(i));
            }
        }
    }
}

// C:\Users\Akulo\Desktop\testFile1.txt