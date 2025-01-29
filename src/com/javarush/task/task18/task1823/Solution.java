package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз (если таких байтов несколько,
выбрать наименьший), и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";

//         1 вариант
//        while (true) {
//            fileName = reader.readLine();
//            if (fileName.equals("exit")) {
//                break;
//            }
//            ReadThread readThread = new ReadThread(fileName);
//            readThread.start();
//        }
//        System.out.println(resultMap);

        // 2 вариант
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        String name;
        int requiredByte;
        public ReadThread(String fileName) {
            //implement constructor body
            this.name = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            // 1 вариант
//            List<Integer> sourceByteList = new ArrayList<>();
//            try (FileInputStream inputStream = new FileInputStream(name)) {
//                while (inputStream.available() > 0) {
//                    sourceByteList.add(inputStream.read());
//                }
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            sourceByteList.sort(Comparator.reverseOrder());
//            List<Integer> changedList = sourceByteList.stream().distinct().collect(Collectors.toList());
//
//            int maxCount = 0;
//            for (int i = 0; i < changedList.size(); i++) {
//                int currentEl = changedList.get(i);
//                int currentCount = sourceByteList.lastIndexOf(currentEl) - sourceByteList.indexOf(currentEl) + 1;
//                if (currentCount > maxCount) {
//                    maxCount = currentCount;
//                }
//            }
//
//            List<Integer> resultList = new ArrayList<>();
//            for (int i = 0; i < changedList.size(); i++) {
//                int currentEl = changedList.get(i);
//                int currentCount = sourceByteList.lastIndexOf(currentEl) - sourceByteList.indexOf(currentEl) + 1;
//                if (currentCount == maxCount) {
//                    resultList.add(currentEl);
//                }
//            }
//            int minElement = Collections.min(resultList);
//            resultMap.put(name, minElement);

            // 2 вариант
            byte[] bytesCount = new byte[256];
            try (FileInputStream inputStream = new FileInputStream(name)) {
                while (inputStream.available() > 0) {
                    int aByte = inputStream.read();
                    bytesCount[aByte]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxCount = 0;
            int maxCountByte = 0;
            for (int i = 0; i < bytesCount.length; i++) {
                if (bytesCount[i] > maxCount) {
                    maxCount = bytesCount[i];
                    maxCountByte = i;
                }
            }
            resultMap.put(name, maxCountByte);
        }
    }
}
