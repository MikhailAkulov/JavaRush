package com.javarush.task.task14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    // 1 вариант
//    public static void println(Bridge bridge) {
//        if (bridge instanceof WaterBridge) {
//            System.out.println(new WaterBridge().getCarsCount());
//        } else if (bridge instanceof SuspensionBridge) {
//            System.out.println(new SuspensionBridge().getCarsCount());
//        }
//    }

    // 2 вариант
    public static void println(Bridge waterBridge) {
        System.out.println(waterBridge.getCarsCount());
    }
}

