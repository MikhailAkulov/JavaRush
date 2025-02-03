package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.
*/

public class Solution {
    private static int counter = 0;

    public static void main(String[] args) throws IOException {
        String fileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        // 1 вариант
//        String str = "";
//        try (FileReader fileReader = new FileReader(fileName)){
//            while (fileReader.ready()) {
//                char ch = (char) fileReader.read();
//                str += ch;
//            }
//        }
//        String resultStr = str.replaceAll("[^a-zA-Z[-' \n]]", " ");
//        String[] strArray = resultStr.split("[ \n]");
//        int count = 0;
//        for (String s : strArray) {
//            if ("world".equals(s)) {
//                count++;
//            }
//        }
//        System.out.println(count);

        // 2 вариант
        StringBuilder text = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName)) {
            char currentChar;
            while (fileReader.ready()) {
                currentChar = (char) fileReader.read();
                text.append(currentChar);
            }
        }
        String replacedString = text.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

        for (String x : replacedString.split(" ")) {
            if (x.equals("world")) {
                counter++;            }
        }
        System.out.println(counter);
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFileLoremIpsum.txt
// C:\Users\Akulo\Desktop\SourceDirectory\Metallica.txt