package com.javarush.task.task19.extraExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Task1904 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile1904.txt"));
        String sourceStr = sc.nextLine();

        String[] strArray = sourceStr.split(" ");
        Date date = new Date();
        date.setYear(Integer.parseInt(strArray[5].substring(2)));
        date.setMonth(Integer.parseInt(strArray[4])-1);
        date.setDate(Integer.parseInt(strArray[3]));
        System.out.println(strArray[0] + " " + strArray[1] + " " + strArray[2] + " " + date);
    }
}
