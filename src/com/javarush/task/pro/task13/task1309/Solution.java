package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Студент1", 4.1);
        grades.put("Студент2", 4.9);
        grades.put("Студент3", 3.5);
        grades.put("Студент4", 4.4);
        grades.put("Студент5", 4.3);
    }
}