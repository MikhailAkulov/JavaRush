package com.javarush.task.pro.task15.task1504;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             var inputStream = Files.newInputStream(Paths.get(sc.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(sc.nextLine()))) {
            byte[] buffer = new byte[65536];
            while (inputStream.available() > 0) {
                int real = inputStream.read(buffer);
                for (int i = 0; i < real-2; i = i + 2) {
                    byte tmp = buffer[i];
                    buffer[i] = buffer[i + 1];
                    buffer[i + 1] = tmp;
                }
                outputStream.write(buffer, 0, real);
            }
        } catch (IOException e) {
            System.out.println("catch exception: " + e);;
        }
    }
}

