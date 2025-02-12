package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.*;

/* 
Хуан Хуанович

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int,
[месяц] - int,
[год] - int данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = null;
        if (args.length == 0) {
            System.out.println("Исходный параметр отсутствует");
        } else {
            fileName = args[0];
        }

        List<String> sourceList = new ArrayList<>();
        if (fileName != null) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
                String currentLine;
                while ((currentLine = fileReader.readLine()) != null) {
                    sourceList.add(currentLine);
                }

            } catch (IOException ignore) {
            }
        }

        for (String str : sourceList) {
            String[] splitedStr = str.split(" ");
            int year = Integer.parseInt(splitedStr[splitedStr.length - 1]);
            int month = Integer.parseInt(splitedStr[splitedStr.length - 2]);
            int day = Integer.parseInt(splitedStr[splitedStr.length - 3]);
            String name = "";
            Calendar birthdayDate = new GregorianCalendar(year, month-1, day);
            for (int i = splitedStr.length - 4; i >= 0; i--) {
                name = splitedStr[i] + " " + name;
            }
            PEOPLE.add(new Person(name.trim(), birthdayDate.getTime()));
        }

        for (Person p : PEOPLE) {
            System.out.println(p.toString());
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\testFile1921.txt