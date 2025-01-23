package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Разделение файла

Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        // 1 вариант (не прошёл валидатор)
//        List<Integer> sourceList = new ArrayList<>();
//        try (FileInputStream inputStream = new FileInputStream(fileName1)) {
//            while (inputStream.available() > 0) {
//                int data = inputStream.read();
//                sourceList.add(data);
//            }
//        }
//
//        try (FileOutputStream outputStream1 = new FileOutputStream(fileName2);
//             FileOutputStream outputStream2 = new FileOutputStream(fileName3)) {
//            for (int i = 0; i < sourceList.size(); i++) {
//                int currentData = sourceList.get(i);
//                if (i <= sourceList.size() / 2) {
//                    outputStream1.write(currentData);
//                } else {
//                    outputStream2.write(currentData);
//                }
//            }
//        }

        // 2 вариант (прошёл валидатор)
//        try (FileInputStream inputStream = new FileInputStream(fileName1);
//             FileOutputStream outputStream1 = new FileOutputStream(fileName2);
//             FileOutputStream outputStream2 = new FileOutputStream(fileName3)) {
//            if (inputStream.available() > 0) {
//                byte[] buffer = new byte[inputStream.available()];
//                int count = inputStream.read(buffer);
//                if (count % 2 != 0) {
//                    int half = count / 2 + 1;
//                    outputStream1.write(buffer, 0, half);
//                    outputStream2.write(buffer, half, count-half);
//                } else {
//                    int half = count / 2;
//                    outputStream1.write(buffer, 0, half);
//                    outputStream2.write(buffer, half, count-half);
//                }
//            }
//        }

        // 3 вариант
        try (FileInputStream inputStream = new FileInputStream(fileName1);
             FileOutputStream outputStream1 = new FileOutputStream(fileName2);
             FileOutputStream outputStream2 = new FileOutputStream(fileName3)) {
            int halfOfFile = (inputStream.available() + 1) / 2;
            int numberOfByte = 0;
            while (inputStream.available() > 0) {
                if (numberOfByte < halfOfFile) {
                    outputStream1.write(inputStream.read());
                    numberOfByte++;
                } else {
                    outputStream2.write(inputStream.read());
                }
            }
        }
    }
    // C:\Users\Akulo\Desktop\SourceDirectory\testFile.txt
    // C:\Users\Akulo\Desktop\SourceDirectory\testFile1.txt
    // C:\Users\Akulo\Desktop\SourceDirectory\testFile2.txt
}
