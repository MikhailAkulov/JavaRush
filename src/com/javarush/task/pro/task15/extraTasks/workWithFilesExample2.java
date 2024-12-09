package com.javarush.task.pro.task15.extraTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class workWithFilesExample2 {
    public static void main(String[] args) throws IOException {

        //  readAllLines
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\pushkin.txt"));

        for (String str : lines) {
            System.out.println(str);
        }
    }
}
