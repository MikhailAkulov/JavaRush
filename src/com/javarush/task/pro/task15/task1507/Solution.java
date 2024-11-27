package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)){
            List<String> list = Files.readAllLines(Paths.get(sc.nextLine()));
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 0) {
                    System.out.println(list.get(i));
                }
            }
            // вариант 2
//            for (int i = 0; i < list.size(); i += 2) {
//                System.out.println(list.get(i));
//            }
        }
    }
}

