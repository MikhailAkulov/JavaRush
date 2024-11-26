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

            // C:\Users\Akulo\Desktop\log.txt
        } catch (IOException e) {
            System.out.println("catch IOException " + e);
        }
    }
}

