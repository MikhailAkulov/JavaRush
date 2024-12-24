package com.javarush.task.task15.task1518;

/* 
Статики и котики

нужно:
1. Создать класс Cat с публичным полем name типа String в классе Solution.
2. В статическом блоке создать объект типа Cat и инициализировать им переменную cat (не забудь инициализировать поле name).
3. В статическом блоке вывести имя созданного кота на экран.
*/

public class Solution {

    public static class Cat {
        public String name;
    }

    public static Cat cat;

    static {
        Solution.cat = new Cat();
        cat.name = "anyCat";
        System.out.println(cat.name);
    }

    public static void main(String[] args) {

    }
}
