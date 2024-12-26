package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке

1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();


    static {
        // 1 вариант
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
//            while (reader.ready()) {
//                String currentStr = reader.readLine();
//                lines.add(currentStr);
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 2 вариант
        String line;
        try {
            FileReader fileReader = new FileReader(Statics.FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException fN) {
            fN.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
