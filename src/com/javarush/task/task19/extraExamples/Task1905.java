package com.javarush.task.task19.extraExamples;

public class Task1905 {
    public static void main(String[] args) {
        String str = "+38(050)123-45-67";
        String number = str.replaceAll("\\D", "");
        String result = "callto://+";
        System.out.println(result + number);
    }
}
