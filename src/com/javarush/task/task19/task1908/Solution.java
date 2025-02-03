package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Выделяем числа

Считать с консоли 2 пути к файлам.
Вывести во второй файл все целые числа, которые есть в первом файле (54у не является числом).
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        // 1 вариант
//        String str = "";
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
//            while (fileReader.ready()) {
//                str += fileReader.readLine();
//            }
//        }
//
//        String[] strArray = str.split(" ");
//        List<Integer> numArray = new ArrayList<>();
//        for (String s : strArray) {
//            try {
//                int i = Integer.parseInt(s);
//                numArray.add(i);
//            } catch (NumberFormatException e) {
//                //e.printStackTrace();
//            }
//        }
//
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
//            for (Integer i : numArray) {
//                fileWriter.write(i + " ");
//            }
//        }

        // 2 вариант
        ArrayList<String> fileContent = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
            while (fileReader.ready()) {
                fileContent.add(fileReader.readLine());
            }
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
            for (String line : fileContent) {
                String[] splitLine = line.trim().split(" ");
                for (String word : splitLine) {
                    try {
                        int num = Integer.parseInt(word);
                        fileWriter.write(word + " ");
                    } catch (Exception ignore) {
                        /* NOP */
                    }
                }
            }
        }
    }
}

// C:\Users\Akulo\Desktop\testFile1.txt
// C:\Users\Akulo\Desktop\testFile1Copy.txt