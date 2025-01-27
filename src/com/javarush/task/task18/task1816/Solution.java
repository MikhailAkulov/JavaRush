package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы

В метод main первым параметром приходит путь к файлу.
Посчитать количество символов в файле, которые соответствуют буквам английского алфавита.
Вывести на экран число (количество символов).
Закрыть потоки.
*/

public class Solution {
    // вариант для валидатора
    private final static Character[] ENGLISH_CHARACTERS_ARRAY = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'};
    private final static Set<Character> ENGLISH_CHARACTERS = new HashSet<>(Arrays.asList(ENGLISH_CHARACTERS_ARRAY));

    public static void main(String[] args) throws IOException {
        // 1 вариант (не нравится валидатору)
//        Set<Character> charSet = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
//                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
//                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
//        try (FileReader reader = new FileReader("C:\\Users\\Akulo\\Desktop\\testFile.txt")) {
//            int i;
//            int count = 0;
//            while ((i = reader.read()) != -1) {
//                if (charSet.contains((char) i)) {
//                    count++;
//                }
//            }
//            System.out.println(count);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // 2 вариант (для валидатора)
        int countOfEnglishChars = 0;
        try (FileReader fileReader = new FileReader(args[0])) {
            while (fileReader.ready()) {
                char readChar = (char) fileReader.read();
                if (ENGLISH_CHARACTERS.contains(readChar)) {
                    countOfEnglishChars++;
                }
            }
            System.out.println(countOfEnglishChars);
        }
    }
}
