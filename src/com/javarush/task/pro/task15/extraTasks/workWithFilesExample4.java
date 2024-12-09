package com.javarush.task.pro.task15.extraTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Задача: зная корневой каталог, пройтись по нему, заглянуть в папки всех уровней и найти в них файлы с нужным нам
 * содержимым. Будем искать файлы, содержащие строку «This is the file we need!»
 * Корневым каталогом будет папка «testFolder» на рабочем столе.
 */
public class workWithFilesExample4 {
    public static void main(String[] args) throws IOException {

        Files.walkFileTree(Paths.get("C:\\Users\\Akulo\\Desktop\\testFolder"), new MyFileVisitor());
    }
}
