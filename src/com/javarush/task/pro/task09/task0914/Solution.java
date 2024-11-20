package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        String oldJdkVer = "jdk";
        int oldJdkIndexStart = path.indexOf(oldJdkVer);
        String end = "bin";
        int oldJdkIndexEnd = path.indexOf(end);
        String firstPart = path.substring(0, oldJdkIndexStart);
        String lastPart = path.substring(oldJdkIndexEnd-1);
        return firstPart + jdk + lastPart;
    }
}
