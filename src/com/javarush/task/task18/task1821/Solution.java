package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Встречаемость символов

Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2

Закрыть потоки.

Пример вывода:
, 19
- 7
f 361
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1 вариант
//        List<Integer> sourceList = new ArrayList<>();
//        try (FileReader fileReader = new FileReader(args[0])) {
//            while (fileReader.ready()) {
//                sourceList.add(fileReader.read());
//            }
//        }
//        sourceList.sort(Comparator.naturalOrder());
//        List<Integer> resultList = sourceList.stream().distinct().collect(Collectors.toList());
//        for (int i : resultList) {
//            int count = 0;
//            char symbol = (char) i;
//            for (int c : sourceList) {
//                if (i == c) {
//                    count++;
//                }
//            }
//            System.out.println(symbol + " " + count);
//        }

        // 2 вариант
        int[] aSCII = new int[256];
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                aSCII[reader.read()]++;
            }
        }
        for (int i = 0; i < aSCII.length; i++) {
            if (aSCII[i] != 0) {
                System.out.println((char) i + " " + aSCII[i]);
            }
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile.txt