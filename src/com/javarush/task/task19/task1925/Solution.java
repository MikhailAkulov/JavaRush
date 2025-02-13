package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Длинные слова

В метод main первым параметром приходит путь к файлу1, вторым - путь к файлу2.
Файл1 содержит слова, разделенные пробелом или переводом строки (в файле может быть несколько строк).
Все, что не относится к пробелу или переводу строки, разделителем не считать.
Записать в одну строку через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура
*/

public class Solution {
    public static void main(String[] args) {
        String firstFileName = null;
        String secondFileName = null;
        if (args.length < 2) {
            System.out.println("Исходные параметры отсутствуют");
        } else {
            firstFileName = args[0];
            secondFileName = args[1];
        }

        if (firstFileName != null && secondFileName != null) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
                 FileWriter fileWriter = new FileWriter(secondFileName)) {
                String currentLine;
                List<String> resultList = new ArrayList<>();
                while ((currentLine = fileReader.readLine()) != null) {
                    String[] splitedStr = currentLine.split(" ");
                    for (String word : splitedStr) {
//                        String currentStr = word.trim().replaceAll("\\W", ""); // уберёт символы
                        if (word.length() > 6) {
                            resultList.add(word);
                        }
                    }
                }
                for (int i = 0; i <= resultList.size() - 1; i++) {
                    String currentStr = resultList.get(i);
                    if (i < resultList.size() - 1) {
                        fileWriter.write(currentStr + ",");
                    } else {
                        fileWriter.write(currentStr);
                    }
                }
            } catch (IOException ignore) {
                /* NOP */
            }
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile1925part1.txt
// C:\Users\Akulo\Desktop\SourceDirectory\testFile1925part2.txt