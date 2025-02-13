package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1, abc3d или 564.
Закрыть потоки.
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
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName))) {
                String currentLine;
                while ((currentLine = fileReader.readLine()) != null) {
                    String[] splitedStr = currentLine.split(" ");
                    for (String s : splitedStr) {
                        if (s.length() != s.replaceAll("\\d", "").length()) {
                            fileWriter.write(s + " ");
                        }
                    }
                }
            } catch (IOException ignore) {
                /* NOP */
            }
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile1923part1.txt
// C:\Users\Akulo\Desktop\SourceDirectory\testFile1923part2.txt