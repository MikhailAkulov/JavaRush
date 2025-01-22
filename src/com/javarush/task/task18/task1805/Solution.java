package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/* 
Сортировка байт

Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Integer> sourceList = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                sourceList.add(data);
            }
        }

        Set<Integer> resultSet = new TreeSet<>();
        resultSet.addAll(sourceList);
        for (Integer i : resultSet) {
            System.out.print(i + " ");
        }

        // 2 вариант
//        Set<Integer> bytes = new TreeSet<>();
//        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
//            while (fileInputStream.available() > 0) {
//                bytes.add(fileInputStream.read());
//            }
//        }
//        for (Integer aByte : bytes) {
//            System.out.print(aByte + " ");
//        }
    }
}
