package com.javarush.task.pro.task15.task1515;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path path = Path.of(str);
        boolean isAbc = path.isAbsolute();
        if (isAbc) {
            System.out.println(path);
        } else {
            System.out.println(path.toAbsolutePath());
        }
    }
}

