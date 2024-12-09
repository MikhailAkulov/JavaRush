package com.javarush.task.pro.task15.extraTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Работа с Files
 */
public class workWithFilesExample1 {
    public static void main(String[] args) throws IOException {
        //  создание файла
        Path testFile1 = Files.createFile(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile1.txt"));
        System.out.print("Был ли файл успешно создан? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile1.txt")));

        //  создание директории
        Path testDirectory = Files.createDirectory(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory"));
        System.out.print("Была ли директория успешно создана? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory")));

        //  перемещаем файл в директорию testDirectory. Перемещать надо с указанием имени файла в папке!
        testFile1 = Files.move(testFile1, Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory\\testFile1.txt"), REPLACE_EXISTING);

        System.out.print("Остался ли файл на прежнем месте? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile1.txt")));

        System.out.print("Был ли файл перемещен в testDirectory? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory\\testFile1.txt")));

        //  удаление файла
        Files.delete(testFile1);
        System.out.print("Файл все еще существует? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory\\testFile1.txt")));

        System.out.println();

        //  копирование файла
        Path testFile2 = Files.createFile(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile2.txt"));
        System.out.print("Был ли файл успешно создан? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile2.txt")));

        Path testDirectory2 = Files.createDirectory(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory2"));
        System.out.print("Была ли директория успешно создана? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory2")));

        testFile2 = Files.copy(testFile2, Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory2\\testFile2.txt"), REPLACE_EXISTING);
        System.out.print("Остался ли файл на прежнем месте? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile2.txt")));

        System.out.print("Был ли файл перемещен в testDirectory2? - ");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testDirectory2\\testFile2.txt")));
    }
}
