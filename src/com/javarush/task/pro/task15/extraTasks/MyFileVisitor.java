package com.javarush.task.pro.task15.extraTasks;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Для задачи из workWithFilesExample4
 * Класс наследуется от SimpleFileVisitor. Это класс, реализующий FileVisitor,
 * в котором нужно переопределить всего один метод: visitFile().
 * Здесь описывается, что нужно делать с каждым файлом в каждой директории.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        List<String> lines = Files.readAllLines(file);
        for (String s : lines) {
            if (s.contains("This is the file we need")) {
                System.out.println("Нужный файл найден!");
                System.out.println(file.toAbsolutePath());
                break;
            }
        }
        return FileVisitResult.CONTINUE;    //  продолжать обход дерева
    }
}
