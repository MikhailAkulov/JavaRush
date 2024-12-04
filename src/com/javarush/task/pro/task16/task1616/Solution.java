package com.javarush.task.pro.task16.task1616;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        // 1 Вариант
//        TreeSet<String> treeSet = new TreeSet<>();
//        for (String s : ZoneId.getAvailableZoneIds()) {
//            treeSet.add(s);
//        }
//        return treeSet;

        // 2 Вариант
        return new TreeSet<>(ZoneId.getAvailableZoneIds());
    }

    static ZonedDateTime getBeijingDateTime() {
        // 1 Вариант
        ZoneId zone = ZoneId.of("Asia/Shanghai");
//        ZonedDateTime today = ZonedDateTime.now(zone);
//        return today;

        // 2 Вариант
        return ZonedDateTime.now(zone);
    }
}
