package com.javarush.task.pro.task16.task1617;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* 
Временная глобализация
*/

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.of(2020, 3, 19, 9, 17);
    static ZoneId zoneId = ZoneId.of("Zulu");
    static ZonedDateTime globalTime;

    public static void main(String[] args) {
        // 1 вариант
//        globalTime = ZonedDateTime.of(localDateTime, zoneId);

        // 2 вариант
        globalTime = localDateTime.atZone(zoneId);
        System.out.println(globalTime);
    }
}
