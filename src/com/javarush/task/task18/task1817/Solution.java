package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы

В метод main первым параметром приходит путь к файлу.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой до ближайшего.
4. Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int countOfChars = 0;
        int countOfSpace = 0;
        try (FileReader fileReader = new FileReader(args[0])) {
            while (fileReader.ready()) {
                char currentChar = (char) fileReader.read();
                if (currentChar == ' ') {
                    countOfSpace++;
                }
                countOfChars++;
            }
        }
        if (countOfChars != 0) {
            double value = (double) countOfSpace / countOfChars * 100;
//            String result = String.format("%.2f", value);
//            System.out.println(result);
            System.out.printf("%.2f", value);
        }
    }
}
