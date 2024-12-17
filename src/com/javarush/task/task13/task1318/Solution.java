package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Чтение файла
*/

/**
 * В этой задаче тебе нужно:
 * Считать с консоли путь к файлу.
 * Вывести в консоли (на экран) содержимое файла.
 * Освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader buffer = null;

        try {
            scanner = new Scanner(System.in);
            inputStream = new FileInputStream(String.valueOf(Paths.get(scanner.nextLine())));
            reader = new InputStreamReader(inputStream);
            buffer = new BufferedReader(reader);

            while (buffer.ready()) {
                String str = buffer.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            inputStream.close();
            reader.close();
            buffer.close();
        }

        // вариант 2
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String sourceFileName = reader.readLine();
//        FileInputStream fileInputStream = new FileInputStream(sourceFileName);
//
//        Scanner scanner = new Scanner(fileInputStream);
//        StringBuilder builder = new StringBuilder();
//
//        while (scanner.hasNextLine()) {
//            builder.append(scanner.nextLine()).append("\n");
//        }
//
//        System.out.print(builder.toString());
//
//        scanner.close();
//        reader.close();
    }
}