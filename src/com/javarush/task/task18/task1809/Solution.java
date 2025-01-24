package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла

Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        List<Integer> sourceList = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName1);
             FileOutputStream outputStream = new FileOutputStream(fileName2)) {
            while (inputStream.available() > 0) {
                sourceList.add(inputStream.read());
            }
            Collections.reverse(sourceList);
            for (Integer i : sourceList) {
                outputStream.write(i);
            }
        }
        // C:\Users\Akulo\Desktop\SourceDirectory\testFile.txt
        // C:\Users\Akulo\Desktop\SourceDirectory\testFile1.txt
    }
}
