package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1988, Calendar.JULY, 4);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            return "Понедельник";
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            return "Вторник";
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            return "Среда";
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            return "Четверг";
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            return "Пятница";
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return "Суббота";
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return "Воскресенье";
        }
        return null;
    }
}
