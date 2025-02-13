package com.javarush.task.task19.extraExamples;

/*
Слова с цифрами

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1, abc3d или 564.
Закрыть потоки.
*/

import java.io.*;

public class Task1923 {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            String fileReadLine;
            String[] splitedLine;
            while ((fileReadLine = fileReader.readLine()) != null) {
                splitedLine = fileReadLine.split(" ");
                for (String word : splitedLine) {
                    if (word.matches(".*[0-9].*")) {
                        fileWriter.write(word + " ");
                    }
                }
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
