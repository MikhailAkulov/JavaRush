package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые частые байты

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = buffReader.readLine();

        // 1 вариант
//        List<Integer> byteArray = new ArrayList<>();
//        try (FileInputStream inputStream = new FileInputStream(fileName)) {
//            while (inputStream.available() > 0) {
//                int currentByte = inputStream.read();
//                byteArray.add(currentByte);
//            }
//        }
//        byteArray.sort(Comparator.reverseOrder());
//        List<Integer> copy = byteArray.stream().distinct().collect(Collectors.toList());
//
//        int maxCount = 0;
//        for (int i = 0; i < copy.size(); i++) {
//            int currentElement = copy.get(i);
//            int currentCount = byteArray.lastIndexOf(currentElement) - byteArray.indexOf(currentElement);
//            if (currentCount > maxCount) {
//                maxCount = currentCount;
//            }
//        }
//
//        String str ="";
//        for (int i = 0; i < copy.size(); i++) {
//            int currentElement = copy.get(i);
//            int currentCount = byteArray.lastIndexOf(currentElement) - byteArray.indexOf(currentElement);
//            if (maxCount == currentCount) {
//                str += currentElement;
//            }
//        }
//        System.out.println(str);

        // 2 вариант
        int[] byteCountArray = new int[256];
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                byteCountArray[inputStream.read()] += 1;
            }
        }

        int maxCount = 0;
        for (int byteCount : byteCountArray) {
            if (byteCount > maxCount) {
                maxCount = byteCount;
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < byteCountArray.length; i++) {
            if (byteCountArray[i] == maxCount) {
                resultList.add(i);
            }
        }
        for (Integer resultItem : resultList) {
            System.out.print(resultItem + " ");
        }
    }
    // C:\Users\Akulo\Desktop\SourceDirectory\pushkin.txt
}
