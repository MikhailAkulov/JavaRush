package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Округление чисел

Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        // 1 вариант
//        try (FileInputStream inputStream = new FileInputStream(fileName1);
//             FileOutputStream outputStream = new FileOutputStream(fileName2)) {
//            String sourceStr = "";
//            while (inputStream.available() > 0) {
//                char currentChar = (char) inputStream.read();
//                sourceStr += currentChar;
//            }
//            String[] strArray = sourceStr.split(" ");
//            List<Double> doubleList = new ArrayList<>();
//            for (String s : strArray) {
//                doubleList.add(Double.parseDouble(s));
//            }
//            String resultStr = "";
//            for (Double d : doubleList) {
//                int i = (int) Math.round(d);
//                resultStr += i + " ";
//            }
//            outputStream.write(resultStr.getBytes());
//        }

        // 2 вариант
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
             PrintWriter printWriter = new PrintWriter(new FileWriter(fileName2))) {

            while (bufferedFileReader.ready()) {
                String[] splittedLine = bufferedFileReader.readLine().split(" ");
                for (String numberInString : splittedLine) {
                    double number = Double.parseDouble(numberInString);
                    long roundedNumber = Math.round(number);
                    printWriter.print(roundedNumber + " ");
                }
            }
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\sourceFile.txt
// C:\Users\Akulo\Desktop\SourceDirectory\destFile.txt