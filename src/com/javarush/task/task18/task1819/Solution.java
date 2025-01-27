package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов

Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        // 1 вариант
//        try (FileInputStream inputStream1 = new FileInputStream(file1);
//             FileInputStream inputStream2 = new FileInputStream(file2)) {
//            byte[] buffer1 = new byte[inputStream1.available()];
//            if (inputStream1.available() > 0) {
//                inputStream1.read(buffer1);
//            }
//            byte[] buffer2 = new byte[inputStream2.available()];
//            if (inputStream2.available() > 0) {
//                inputStream2.read(buffer2);
//            }
//            byte[] result = new byte[buffer2.length + buffer1.length];
//            System.arraycopy(buffer2, 0, result, 0, buffer2.length);
//            System.arraycopy(buffer1, 0, result, buffer2.length, buffer1.length);
//            try (FileOutputStream outputStream = new FileOutputStream(file1)) {
//                outputStream.write(result);
//            }
//        }

        // 2 вариант
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream inputStream1 = new FileInputStream(file1);
             FileInputStream inputStream2 = new FileInputStream(file2)) {
            while (inputStream2.available() > 0) {
                byteArrayOutputStream.write(inputStream2.read());
            }
            while (inputStream1.available() > 0) {
                byteArrayOutputStream.write(inputStream1.read());
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream(file1)) {
            byteArrayOutputStream.writeTo(outputStream);
        }
    }
}
