package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя,
String sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990 -с - добавляет всех людей с заданными параметрами
в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat sdfOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        //start here - начни тут
        if (args == null || args.length < 1) {
            System.out.println("Аргументы не переданы");
        }
        try {
            switch (args[0]) {
                case "-c":      // аргументы для запуска: -c Сергеева ж 15/04/1990 Пупкин м 13/12/2000 name2 м 17/01/1987 name3 ж 31/01/1986 name4 м 14/10/1991
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 3) {
                            String name = args[i];
                            String sex = args[i + 1];
                            Date birthdayDate = sdfInput.parse(args[i + 2]);
                            Person person = sex.equals("м") ? Person.createMale(name, birthdayDate) : Person.createFemale(name, birthdayDate);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
//                            System.out.println(person.getName() + " " + person.getSex() + " " + person.getBirthDate());       // трока для проверки результата выполнения
                        }
                    }
                    break;
                case "-u":      // аргументы для запуска: -u 0 Сергеева ж 15/04/1990 1 Пупкин м 13/12/2000 2 name2 м 17/01/1987 3 name3 ж 31/01/1986 4 name4 м 14/10/1991
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 4) {
                            int id = 0;
                            try {
                                id = Integer.parseInt(args[i]);
                                String name = args[i + 1];
                                String sex = args[i + 2];
                                Date birthdayDate = sdfInput.parse(args[i + 3]);
                                allPeople.get(id).setName(name);
                                allPeople.get(id).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                                allPeople.get(id).setBirthDate(birthdayDate);
//                                Person person = allPeople.get(id);        // 2 строки для проверки результата выполнения
//                                System.out.println(person.getName() + " " + person.getSex() + " " + person.getBirthDate());
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Нет человека с индексом: " + id);
                            }
                        }
                    }
                    break;
                case "-d":      // аргументы для запуска: -d 0 1 2 3 4
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = 0;
                            try {
                                id = Integer.parseInt(args[i]);
                                allPeople.get(id).setName(null);
                                allPeople.get(id).setSex(null);
                                allPeople.get(id).setBirthDate(null);
//                                Person person = allPeople.get(id);        // 2 строки для проверки результата выполнения
//                                System.out.println(person.getName() + " " + person.getSex() + " " + person.getBirthDate());
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Нет человека с индексом: " + id);
                            }
                        }
                    }
                    break;
                case "-i":      // аргументы для запуска: -i 0 1 2 3 4
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = 0;
                            try {
                                id = Integer.parseInt(args[i]);
                                Person person = allPeople.get(id);
                                System.out.println(person.getName() + " " +
                                        (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                                        sdfOutput.format(person.getBirthDate()));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Нет человека с индексом: " + id);
                            }
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
