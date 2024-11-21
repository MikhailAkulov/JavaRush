package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths() {
        Month[] winterArray = {DECEMBER, JANUARY, FEBRUARY};
        return winterArray;
    }

    public static Month[] getSpringMonths() {
        Month[] springArray = {MARCH, APRIL, MAY};
        return springArray;
    }

    public static Month[] getSummerMonths() {
        Month[] summerArray = {JUNE, JULY, AUGUST};
        return summerArray;
    }

    public static Month[] getAutumnMonths() {
        Month[] autumnArray = {SEPTEMBER, OCTOBER, NOVEMBER};
        return autumnArray;
    }
}
