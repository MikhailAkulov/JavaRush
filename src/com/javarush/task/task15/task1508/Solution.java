package com.javarush.task.task15.task1508;

/* 
ООП - Перегрузка - убираем лишнее

Посмотри на реализации метода print() в коде и определи, какой из них будет вызван.
Удали все лишние реализации метода print().
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
    }

//    public static void print(byte b) {
//        System.out.println("Я буду Java прогером!");
//    }

//    public static void print(double d) {
//        System.out.println("Я буду Java прогером!");
//    }

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }

//    public static void print(float f) {
//        System.out.println("Я буду Java прогером!");
//    }

//    public static void print(char c) {
//        System.out.println("Я буду Java прогером!");
//    }
}
