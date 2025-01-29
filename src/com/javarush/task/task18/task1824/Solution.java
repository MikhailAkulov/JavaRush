package com.javarush.task.task18.task1824;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/* 
Файлы и исключения

Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException,
вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используй System.exit();
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1 вариант (не нравится валидатору)
//        String fileName = "";
//        while (true) {
//            try {
//                fileName = reader.readLine();
//                if (Files.exists(Path.of(fileName = reader.readLine()))) {
//                    new ReadThread(fileName);
//                } else  {
//                    throw new FileNotFoundException();
//                }
//            } catch (FileNotFoundException e) {
//                System.out.println(fileName);
//                break;
//            }
//        }

        // 2 вариант
        while (true) {
            String fileName = reader.readLine();
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            }
        }
    }

    // для 1-го варианта
//    public static class ReadThread extends Thread {
//        String fileName;
//
//        public ReadThread(String fileName) {
//            this.fileName = fileName;
//        }
//
//        @Override
//        public void run() {
//            try (FileInputStream inputStream = new FileInputStream(fileName)) {
//                while (inputStream.available() > 0) {
//                    inputStream.read();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile.txt