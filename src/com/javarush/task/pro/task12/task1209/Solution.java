package com.javarush.task.pro.task12.task1209;

import java.util.ArrayList;

/* 
Бухгалтерия
*/

public class Solution {
    public static ArrayList<String> waitingEmployees = new ArrayList<>();
    public static ArrayList<String> alreadyGotSalaryEmployees = new ArrayList<>();

    public static void initEmployees() {
        waitingEmployees.add("Гвинно");
        waitingEmployees.add("Гунигерд");
        waitingEmployees.add("Боргелейф");
        waitingEmployees.add("Нифрод");
        waitingEmployees.add("Альбиуф");
        waitingEmployees.add("Иногрим");
        waitingEmployees.add("Фриле");
    }

    public static void main(String[] args) {
        initEmployees();
        for (int i = 0; i < waitingEmployees.size(); i++) {
            paySalary(waitingEmployees.get(i));
        }
    }

    public static void paySalary(String name) {
        if (waitingEmployees.contains(name) && !alreadyGotSalaryEmployees.contains(name)) {
            alreadyGotSalaryEmployees.add(name);
            for (int i = 0; i < waitingEmployees.size(); i++) {
                if (name.equals(waitingEmployees.get(i))) {
                    waitingEmployees.set(i, null);
                }
            }
        }
    }
}
