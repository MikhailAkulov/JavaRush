package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация

Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

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

        ArrayList<String> stringsList = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
            while (fileReader.ready()) {
                stringsList.add(fileReader.readLine());
            }
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
            for (String str : stringsList) {
                // 1 вариант
//                fileWriter.write(str.replaceAll("[^a-zA-Z ]", ""));

                // 2 вариант
                fileWriter.write(str.replaceAll("\\p{P}", ""));
            }
        }
    }
}
