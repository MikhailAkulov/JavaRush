package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

//        byte[] buffer1 = new byte[1024];
//        byte[] buffer2 = new byte[1024];
        try (FileOutputStream outputStream = new FileOutputStream(file1, true);
             FileInputStream inputStream1 = new FileInputStream(file2);
             FileInputStream inputStream2 = new FileInputStream(file3)) {
            while (inputStream1.available() > 0) {
                outputStream.write(inputStream1.read());
//                int count = inputStream1.read(buffer1);
//                outputStream.write(buffer1, 0, count);
            }
            while (inputStream2.available() > 0) {
                outputStream.write(inputStream2.read());
//                int count = inputStream2.read(buffer2);
//                outputStream.write(buffer2, 0, count);
            }
            // C:\Users\Akulo\Desktop\SourceDirectory\testFile.txt
            // C:\Users\Akulo\Desktop\SourceDirectory\testFile1.txt
            // C:\Users\Akulo\Desktop\SourceDirectory\testFile2.txt
        }
    }
}
