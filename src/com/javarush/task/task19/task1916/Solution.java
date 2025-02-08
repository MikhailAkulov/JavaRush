package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения

Считать с консоли 2 пути к файлам - file1, file2.
Файлы содержат строки. Так как file2 является обновленной версией file1, то часть строк совпадает.
Нужно создать объединенную версию строк из обоих файлов и записать эти строки в список lines.

Правила объединения:
1. Если строка в обоих файлах совпадает, то в результат она попадает с операцией (приставкой) SAME.
Например, SAME строка1.
2. Если строка есть в file1, но ее нет в file2, то считаем, что строку удалили и в результат она
попадает с операцией (приставкой) REMOVED.
Например, REMOVED строка2.
3. Если строки нет в file1, но она есть в file2, то считаем, что строку добавили и в результат она
попадает с операцией (приставкой) ADDED.
Например, ADDED строка0.

Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности и означают, что этой строки нет в определенном файле.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
содержимое оригинального файл (file1):
строка1
строка2
строка3
строка4
строка5
строка1
строка2
строка3
строка5
строка0

содержимое "редактированного" файла (file2):
строка1
строка3
строка5
строка0
строка1
строка3
строка4
строка5

результат объединения:
оригинальный   редактированный   общий
file1:         file2:            результат:(lines)

строка1        строка1           SAME строка1
строка2                          REMOVED строка2
строка3        строка3           SAME строка3
строка4                          REMOVED строка4
строка5        строка5           SAME строка5
               строка0           ADDED строка0
строка1        строка1           SAME строка1
строка2                          REMOVED строка2
строка3        строка3           SAME строка3
               строка4           ADDED строка4
строка5        строка5           SAME строка5
строка0                          REMOVED строка0

Пример 2:
содержимое оригинального файла (file1):
строка1

содержимое "редактированного" файла (file2):
строка1
строка0

результат объединения:
оригинальный   редактированный   общий
file1:         file2:            результат:(lines)

строка1        строка1           SAME строка1
               строка0           ADDED строка0
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        List<String> firstFileLines = new ArrayList<>();
        List<String> secondFileLines = new ArrayList<>();
        try (BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2))){
            while (fileReader1.ready()) {
                firstFileLines.add(fileReader1.readLine());
            }
            while (fileReader2.ready()) {
                secondFileLines.add(fileReader2.readLine());
            }
        }

        int indexForFirstList = 0;
        int indexForSecondList = 0;

        while ((indexForFirstList < firstFileLines.size()) && (indexForSecondList < secondFileLines.size())) {
            if (firstFileLines.get(indexForFirstList).equals(secondFileLines.get(indexForSecondList))) {
                lines.add(new LineItem(Type.SAME, firstFileLines.get(indexForFirstList)));
                indexForFirstList++;
                indexForSecondList++;
            } else if ((indexForSecondList + 1 < secondFileLines.size()) && firstFileLines.get(indexForFirstList).equals(secondFileLines.get(indexForSecondList + 1))) {
                lines.add(new LineItem(Type.ADDED, secondFileLines.get(indexForSecondList)));
                indexForSecondList++;
            } else if ((indexForFirstList + 1 < firstFileLines.size()) && firstFileLines.get(indexForFirstList + 1).equals(secondFileLines.get(indexForSecondList))) {
                lines.add(new LineItem(Type.REMOVED, firstFileLines.get(indexForFirstList)));
                indexForFirstList++;
            }
        }

        while (indexForFirstList < (firstFileLines.size())) {
            lines.add(new LineItem(Type.REMOVED, firstFileLines.get(indexForFirstList)));
            indexForFirstList++;
        }
        while (indexForSecondList < (secondFileLines.size())) {
            lines.add(new LineItem(Type.ADDED, secondFileLines.get(indexForSecondList)));
            indexForSecondList++;
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile1916(1).txt
// C:\Users\Akulo\Desktop\SourceDirectory\testFile1916(2).txt