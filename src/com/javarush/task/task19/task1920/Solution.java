package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки. Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        if (args.length == 0) {
            System.out.println("Исходный параметр отсутствует");
        } else {
            fileName = args[0];
        }

        TreeMap<String, Double> sourceMap = new TreeMap<>();
        if (fileName != null) {
            try (BufferedReader filerReader = new BufferedReader(new FileReader(fileName))) {
                String[] splitedLine;
                String line;
                Double currentValue;

                while ((line = filerReader.readLine()) != null) {
                    splitedLine = line.split(" ");
                    String name = splitedLine[0];
                    double value = Double.parseDouble(splitedLine[1]);

                    if (sourceMap.containsKey(name)) {
                        currentValue = sourceMap.get(name);
                        sourceMap.put(name, value + currentValue);
                    } else {
                        sourceMap.put(name, value);
                    }
                }
            } catch (IOException ignore) {
                /* NOP */;
            }

            // 1 вариант
//            double maxValue = 0;
//            for (String key : sourceMap.keySet()) {
//                double currentValue = sourceMap.get(key);
//                if (currentValue > maxValue) {
//                    maxValue = currentValue;
//                }
//            }
//
//            for (String key : sourceMap.keySet()) {
//                double currentValue = sourceMap.get(key);
//                if (currentValue == maxValue) {
//                    System.out.println(key);
//                }
//            }

            // 2 вариант
            double maxValue = sourceMap.firstEntry().getValue();
            for (double value : sourceMap.values()) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }

            TreeSet<String> names = new TreeSet<>();
            for (String name : sourceMap.keySet()) {
                if (maxValue == sourceMap.get(name)) {
                    names.add(name);
                }
            }

            for (String name : names) {
                System.out.println(name);
            }
        }
    }
}
