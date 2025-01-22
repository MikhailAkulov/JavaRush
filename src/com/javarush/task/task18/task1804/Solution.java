package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* 
Самые редкие байты

Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
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

        sourceList.sort(Comparator.naturalOrder());
        List<Integer> copyList = sourceList.stream().distinct().collect(Collectors.toList());

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < copyList.size(); i++) {
            int currentElement = copyList.get(i);
            int currentCount = sourceList.lastIndexOf(currentElement) - sourceList.indexOf(currentElement) + 1;
            if (currentCount < minCount) {
                minCount = currentCount;
            }
        }

        String resultStr = "";
        for (int i = 0; i < copyList.size(); i++) {
            int currentEl = copyList.get(i);
            int currCount = sourceList.lastIndexOf(currentEl) - sourceList.indexOf(currentEl) + 1;
            if (minCount == currCount) {
                resultStr += currentEl + " ";
            }
        }

        System.out.println(resultStr);

        // 2 вариант
//        int[] byteCountArray = new int[256];
//        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
//            while (fileInputStream.available() > 0) {
//                byteCountArray[fileInputStream.read()] += 1;
//            }
//        }
//        int minCount = Integer.MAX_VALUE;
//        for (int byteCount : byteCountArray) {
//            if (byteCount > 0 && byteCount < minCount) minCount = byteCount;
//        }
//        ArrayList<Integer> resultList = new ArrayList<>();
//        for (int i = 0; i < byteCountArray.length; i++) {
//            if (byteCountArray[i] == minCount) resultList.add(i);
//        }
//        for (Integer resultItem : resultList) System.out.print(resultItem + " ");
    }
}
