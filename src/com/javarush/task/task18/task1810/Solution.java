package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException

1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 1 вариант (не нравится валидатору)
//        while (!reader.ready()) {
//            try (FileInputStream inputStream = new FileInputStream(reader.readLine())) {
//                if (inputStream.available() < 1000) {
//                    throw new DownloadException();
//                } else {
//                    while (inputStream.available() > 0) {
//                        System.out.println(inputStream.read());
//                    }
//                }
//            } catch (DownloadException e) {
//                break;
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }

        // 2 вариант
        while (true) {
            String fileName = reader.readLine();
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
                if (inputStream.available() < 1000) {
                    throw new DownloadException();
                }
            }
        }
    }

    public static class DownloadException extends Exception {
        // 1 вариант (не нравится валидатору)
//        public DownloadException() {
//            System.out.println("DownloadException");
//        }
    }
}
