package com.javarush.task.task19.extraExamples;

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

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task1921 {

    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = args[0];

        ArrayList<String> fileContent = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String fileLine;
            while ((fileLine = fileReader.readLine()) != null) {
                fileContent.add(fileLine);
            }
        } catch (IOException ignore) {
            /* NOP */
        }

        for (String fileLine : fileContent) {
            String[] stringArray = fileLine.split(" ");
            StringBuffer name = new StringBuffer();

            for (int i = 0; i < stringArray.length - 3; i++) {
                name.append(stringArray[i]).append(" ");
            }

            int year = Integer.parseInt(stringArray[stringArray.length - 1]);
            int month = Integer.parseInt(stringArray[stringArray.length - 2]) - 1;
            int day = Integer.parseInt(stringArray[stringArray.length - 3]);
            Calendar birthday = new GregorianCalendar(year, month, day);

            PEOPLE.add(new Person(name.toString().trim(), birthday.getTime()));
        }
    }
}

class Person {
    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}