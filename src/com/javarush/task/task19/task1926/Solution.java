package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши

1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго
Пример результата:
.тсиммаргорп - я
огимА
*/

public class Solution {
    public static void main(String[] args) {
        // 1 вариант
//        String fileName = "";
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            fileName = reader.readLine();
//        } catch (IOException ignore) {
//            /* NOP */
//        }
//
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
//            String currentStr;
//            while ((currentStr = fileReader.readLine()) != null) {
//                StringBuilder sb = new StringBuilder(currentStr);
//                System.out.println(sb.reverse());
//            }
//        } catch (IOException ignore) {
//            /* NOP */
//        }

        // 2 вариант
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()))) {
            while (fileIn.ready()) {
                String line = fileIn.readLine();
                System.out.println(new StringBuffer(line).reverse().toString());
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}

//  C:\Users\Akulo\Desktop\SourceDirectory\testFile1926.txt