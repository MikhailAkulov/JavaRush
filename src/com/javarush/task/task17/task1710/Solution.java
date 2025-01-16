package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD

CRUD - Create, Read, Update, Delete.
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-r id
-u id name sex bd
-d id

Значения параметров:
name - имя,
String sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -r:
Миронов м 15-Apr-1990

Если программа запущена с параметрами, то они попадают в массив args (аргумент метода main - String[] args).
Например, при запуске программы c параметрами:
-c name sex bd
получим в методе main
args[0] = "-c"
args[1] = "name"
args[2] = "sex"
args[3] = "bd"
Для запуска кода с параметрами в IDE IntellijIDEA нужно их прописать
в поле Program arguments в меню Run -> Edit Configurations.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    // для 2 варианта
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {
        //напишите тут ваш код
        // 1 вариант
//        if (args == null || args.length < 1) {
//            System.out.println("Аргументов нет");
//        } else {
//            switch (args[0]) {
//                case "-c":
//                    String name = args[1];
//                    String strDate = args[3];
//                    int firstSlash = strDate.indexOf("/");
//                    int secondSlash = strDate.lastIndexOf("/");
//                    String day = strDate.substring(0, firstSlash);
//                    String month = strDate.substring(firstSlash+1, secondSlash);
//                    String year = strDate.substring(secondSlash+3);
//                    Date date1 = new Date(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
//                    if (args[2].equals("м")) {
//                        allPeople.add(Person.createMale(name, date1));
//                    } else if (args[2].equals("ж")) {
//                        allPeople.add(Person.createFemale(name, date1));
//                    }
//                    System.out.println(allPeople.size()-1);
//                    // -c Миронов м 15/04/1990
//                    break;
//                case "-r":
//                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
//                    String sex;
//
//                    try {
//                        int index = Integer.parseInt(args[1]);
//                        Date date2 = allPeople.get(index).getBirthDate();
//                        if (allPeople.get(index).getSex().equals(Sex.MALE)) {
//                            sex = "м";
//                        } else {
//                            sex = "ж";
//                        }
//                        System.out.println(allPeople.get(index).getName() + " " +
//                                sex + " " + formatter.format(date2));
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    } catch (IndexOutOfBoundsException e) {
//                        System.out.println("Нет человека с таким индексом");
//                    }
//                    break;
//                case "-u":
//                    //-u 1 Миронов м 15/04/1990
//                    try {
//                        int index = Integer.parseInt(args[1]);
//                        String strDate2 = args[4];
//                        int firstSlash2 = strDate2.indexOf("/");
//                        int secondSlash2 = strDate2.lastIndexOf("/");
//                        String day2 = strDate2.substring(0, firstSlash2);
//                        String month2 = strDate2.substring(firstSlash2+1, secondSlash2);
//                        String year2 = strDate2.substring(secondSlash2+3);
//                        Date date2 = new Date(Integer.parseInt(year2), Integer.parseInt(month2)-1, Integer.parseInt(day2));
//
//                        allPeople.get(index).setName(args[2]);
//                        if (args[3].equals("м")) {
//                            allPeople.get(index).setSex(Sex.MALE);
//                        } else {
//                            allPeople.get(index).setSex(Sex.FEMALE);
//                        }
//                        allPeople.get(index).setBirthDate(date2);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    } catch (IndexOutOfBoundsException e) {
//                        System.out.println("Нет человека с таким индексом");
//                    }
//                    for (Person p : allPeople) {
//                        System.out.println(p);
//                    }
//                    break;
//                case "-d":
//                    try {
//                        int index = Integer.parseInt(args[1]);
//                        allPeople.get(index).setName(null);
//                        allPeople.get(index).setSex(null);
//                        allPeople.get(index).setBirthDate(null);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    } catch (IndexOutOfBoundsException e) {
//                        System.out.println("Нет человека с таким индексом");
//                    }
//                    for (Person p : allPeople) {
//                        System.out.println(p);
//                    }
//                    break;
//            }
//        }

        // 2 вариант
        if (args == null || args.length < 1) {
            throw new RuntimeException();
        }
        Date birthdayDate;
        Person person;
        switch (args[0]) {
            case "-c":
                birthdayDate = simpleDateFormat.parse(args[3]);

                if (args[2].equals("м")) {
                    person = Person.createMale(args[1], birthdayDate);
                } else {
                    person = Person.createFemale(args[1], birthdayDate);
                }

                allPeople.add(person);
                System.out.println(allPeople.size() - 1);
                break;
            case "-r":
                person = allPeople.get(Integer.parseInt(args[1]));
                if (person != null) {
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") +
                            " " + simpleDateFormat2.format(person.getBirthDate()));
                }
                break;
            case "-u":
                birthdayDate = simpleDateFormat.parse(args[4]);
                int id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                if (person == null) {
                    throw new IllegalArgumentException();
                }
                person.setSex(getSex(args[3]));
                person.setBirthDate(birthdayDate);
                person.setName(args[2]);
                allPeople.set(id,person);
                break;
            case "-d":
                Person currentPerson = allPeople.get(Integer.parseInt(args[1]));
                currentPerson.setName(null);
                currentPerson.setSex(null);
                currentPerson.setBirthDate(null);
                break;
        }
    }

    private static  Sex getSex(String sexParam) {
        return sexParam.equals("м") ? Sex.MALE : Sex.FEMALE;
    }
}
