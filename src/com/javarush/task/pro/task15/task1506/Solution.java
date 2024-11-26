package com.javarush.task.pro.task15.task1506;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<String> list = Files.readAllLines(Path.of(sc.nextLine()));
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                for (int j = 0; j < str.length(); j++) {
                    Character ch = str.charAt(j);
                    if (ch == ' ' || ch == ',' || ch == '.') {
                        continue;
                    }
                    System.out.print(ch);
                }
            }
        } catch (IOException e) {
            System.out.println("catch IOException " + e);
        }

        // вариант 2
//        try (Scanner scanner = new Scanner(System.in)) {
//            List<String> lines = Files.readAllLines(Paths.get(scanner.nextLine()));
//            lines.forEach(str -> {
//                char[] chars = str.toCharArray();
//                for (char character : chars) {
//                    if (character != ' ' && character != '.' && character != ',') {
//                        System.out.print(character);
//                    }
//                }
//            });
//        } catch (Exception e) {
//            System.out.println("Something went wrong : " + e);
//        }
    }
}

