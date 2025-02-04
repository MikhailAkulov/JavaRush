package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков

Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки "." на знак "!".
Результат вывести во второй файл.
Закрыть потоки.
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
//        String sourceStr = "";
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
//            String currentStr;
//            while (fileReader.ready()) {
//                currentStr = fileReader.readLine();
//                sourceStr += currentStr;
//            }
//        }
//
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
//            String resultStr = sourceStr.replaceAll("\\.", "!");
//            fileWriter.write(resultStr);
//        }

        // 2 вариант
        ArrayList<String> fileContent = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
            while (fileReader.ready()) {
                fileContent.add(fileReader.readLine());
            }
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
            for (String s : fileContent) {
                fileWriter.write(s.replaceAll("\\.", "!"));
            }
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFileLoremIpsum.txt
// C:\Users\Akulo\Desktop\SourceDirectory\testFileLoremIpsum2.txt