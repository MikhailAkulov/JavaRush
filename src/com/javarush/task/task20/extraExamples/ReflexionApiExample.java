package com.javarush.task.task20.extraExamples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexionApiExample {
    public static void main(String[] args) {
        /**
         * Попробуем добраться до private поля name класса MyClass
         */
//        MyClass myClass = new MyClass();
//        int number = myClass.getNumber();
//        String name = null;     // ?
//        printData(myClass);     // output 0default
//        try {
//            Field field = myClass.getClass().getDeclaredField("name");
//            field.setAccessible(true);
//            field.set(myClass, (String) "new value");   // Если у нас не оказалось setter’a, для установки нового значения полю name можно использовать метод set
//            name = (String) field.get(myClass);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        printData(myClass);     // output 0new value

        /**
         * Создадим экземпляр класса с помощью рефлексии
         * данный способ будет работать только с конструктором по умолчанию (без параметров).
         */
//        MyClass myClass1 = null;
//        try {
//            Class clazz = Class.forName(MyClass.class.getName());   // узнать имя класса (вернет имя класса в виде строки)
//            myClass1 = (MyClass) clazz.newInstance();
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        }
//        System.out.println(myClass1);   // output created object com.javarush.task.task20.extraExamples.MyClass@378bf509

        /**
         * Как же вызывать методы с аргументами и конструкторы с параметрами?
         * раскомментируем конструктор в классе MyClass
         * Перепишем создание экземпляра класса
         *
         * Для получения конструкторов класса следует у описания класса вызвать метод getConstructors(),
         * а для получения параметров конструктора - getParameterTypes():
         */
        MyClass myClass2 = null;
        try {
            Class clazz2 = Class.forName(MyClass.class.getName());
            Class[] params = {int.class, String.class};
            myClass2 = (MyClass) clazz2.getConstructor(params).newInstance(1, "default2");

            Constructor[] constructors = clazz2.getConstructors();
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();       // output: int java.lang.String
            }
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(myClass2);   // output created object com.javarush.task.task20.extraExamples.MyClass@eed1f14


    }

    /**
     * Получим доступ к приватому методу printData() класса MyClass
     */
    public static void printData(Object myClass) {
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

/**
 * getter для поля name отсутствует.
 * Само поле name помечено модификатором доступа private,
 * обратиться к нему вне самого класса у нас не выйдет => мы не можем получить его значение.
 * Самое время вспомнить о рефлексии!
 */
class MyClass {
    private int number;
    private String name = "default";

    public MyClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printData() {
        System.out.println(number + name);
    }
}