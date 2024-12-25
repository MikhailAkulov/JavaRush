package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока

нужно:
1. Создать в отдельных файлах классы Plane и Helicopter, реализующие интерфейс CanFly.
2. Класс Plane должен иметь конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset() класса Solution:
- считать с консоли параметр типа String;
- если параметр равен "helicopter", статическому объекту CanFly result присвоить объект класса Helicopter;
- если параметр равен "plane", считать второй параметр типа int (количество пассажиров), статическому объекту CanFly result присвоить объект класса Plane.
4. В статическом блоке инициализировать CanFly result, вызвав метод reset().
5. Закрыть поток ввода методом close().
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() throws IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String key = reader.readLine();
            if (key.equals("helicopter")) {
                result = new Helicopter();
            } else if (key.equals("plane")) {
                key = reader.readLine();
                result = new Plane(Integer.parseInt(key));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
