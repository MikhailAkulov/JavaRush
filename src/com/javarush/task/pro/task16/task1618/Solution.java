package com.javarush.task.pro.task16.task1618;

import java.time.*;
import java.time.temporal.TemporalAccessor;

/* 
Лишь бы не запутаться
*/

public class Solution {

    public static void main(String[] args) {
        ZoneId zone1 = ZoneId.of("Zulu");
        ZoneId zone2 = ZoneId.of("Etc/GMT+8");
        System.out.println(ZonedDateTime.now(zone1));
        System.out.println(ZonedDateTime.now(zone2));

        LocalDateTime time = changeZone(LocalDateTime.of(2020, 3, 19, 1, 40), zone1, zone2);
        System.out.println(time);
    }

    static LocalDateTime changeZone(LocalDateTime fromDateTime, ZoneId fromZone, ZoneId toZone) {
        ZonedDateTime sourceDate = fromDateTime.atZone(fromZone);
        ZonedDateTime destDate = sourceDate.withZoneSameInstant(toZone);

        return destDate.toLocalDateTime();
    }
}
