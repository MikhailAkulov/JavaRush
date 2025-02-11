package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        if (args.length == 0) {
            System.out.println("Параметр отсутствует");
        } else {
            fileName = args[0];
        }

        // 1 вариант
//        Map<String, Double> sourceMap = new TreeMap<>();
//        if (fileName != null) {
//            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
//                while (fileReader.ready()) {
//                    String currentStr = fileReader.readLine();
//                    int spaceIndex = currentStr.indexOf(" ");
//                    String currentKey = currentStr.substring(0, spaceIndex);
//                    Double currentValue = Double.valueOf(currentStr.substring(spaceIndex + 1));
//                    if (sourceMap.isEmpty()) {
//                        sourceMap.put(currentKey, currentValue);
//                    } else if (sourceMap.containsKey(currentKey)){
//                        for (Map.Entry<String, Double> entry: sourceMap.entrySet()) {
//                            if (!entry.getKey().equals(currentKey)) {
//                                continue;
//                            } else {
//                                sourceMap.replace(currentKey, entry.getValue(), entry.setValue(entry.getValue() + currentValue));
//                            }
//                        }
//                    } else {
//                        sourceMap.putIfAbsent(currentKey, currentValue);
//                    }
//                }
//            } catch (FileNotFoundException ignore) {
//            } catch (IOException ignore) {
//            }
//        }
//        for (Map.Entry<String, Double> entry: sourceMap.entrySet()) {
//            String key = entry.getKey();
//            Double value = entry.getValue();
//            System.out.println(key + " " + value);
//        }

        // 2 вариант
        TreeMap<String, Double> salary = new TreeMap<>();
        if (fileName != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                String[] splitedLine;
                String line;
                Double currentValue;

                while ((line = reader.readLine()) != null) {
                    splitedLine = line.split(" ");
                    String name = splitedLine[0];
                    double value = Double.parseDouble(splitedLine[1]);

                    if (salary.containsKey(name)) {
                        currentValue = salary.get(name);
                        salary.put(name, value + currentValue);
                    } else {
                        salary.put(name, value);
                    }
                }
            } catch (IOException ignore) {
                /*NOP */
            }
            for (String key : salary.keySet()) {
                System.out.println(key + " " + salary.get(key));
            }
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile1919.txt