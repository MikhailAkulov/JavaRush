package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        //Работает, но не нравится валидатору из-за разницы в именах файлов
//        try (DirectoryStream<Path> files = Files.newDirectoryStream(sourceDirectory)) {
//            int count = 1;
//            for (Path path : files) {
//                if (Files.isRegularFile(path)) {
//                    String str = "\\new"+count+".txt";
//                    if (Files.exists(targetDirectory)) {
//                        if (Files.isDirectory(targetDirectory)) {
//                            Files.copy(path, Path.of(targetDirectory + str));
//                        }
//                    } else {
//                        Files.createDirectory(targetDirectory);
//                        Files.copy(path, Path.of(targetDirectory + str));
//                    }
//                    count++;
//                } else if (Files.isDirectory(path)) {
//                    continue;
//                }
//            }
//        }



        try (DirectoryStream<Path> files = Files.newDirectoryStream(sourceDirectory)) {
            for (Path path : files) {
                if (Files.isRegularFile(path)) {
                    if (Files.exists(targetDirectory)) {
                        if (Files.isDirectory(targetDirectory)) {
                            Files.copy(path, targetDirectory.resolve(path.getFileName()));
                        }
                    } else {
                        Files.createDirectory(targetDirectory);
                        Files.copy(path, targetDirectory.resolve(path.getFileName()));
                    }
                } else if (Files.isDirectory(path)) {
                    continue;
                }
            }
        }
    }
}

