package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки

Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В (количество слов в списке words может быть любым).

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException ignore) {
            /* NOP */
        }

        String currentLine;
        int passCount = 2;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while ((currentLine = fileReader.readLine()) != null) {
                int currentCount = 0;
                String[] splitedStr = currentLine.split(" ");
                for (String s : splitedStr) {
                    if (words.contains(s)) {
                        currentCount++;
                    }
                }
                if (currentCount == passCount) {
                    System.out.println(currentLine);
                }
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile1922.txt