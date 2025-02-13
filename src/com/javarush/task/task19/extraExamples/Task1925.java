package com.javarush.task.task19.extraExamples;

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

import java.io.*;
import java.util.ArrayList;

public class Task1925 {
    public static void main(String[] args) {
        String fileName1 = args[0];
        String fileName2 = args[1];
        String input;

        ArrayList<String> fileContent = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
            while ((input = fileReader.readLine()) != null) {
                fileContent.add(input);
            }
        } catch (IOException ignore) {
            /* NOP */
        }

        StringBuffer sbLine = new StringBuffer();
        for (String line : fileContent) {
            String[] splitedLine = line.split(" ");
            for (String word : splitedLine) {
                if (word.length() > 6) {
                    sbLine.append(word).append(" ");
                }
            }
        }

        String resultLine = sbLine.toString().trim().replaceAll(" ", ",");
        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            fileWriter.write(resultLine);
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
