package com.javarush.task.pro.task15.extraTasks;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Некоторые методы работы с Path
 */
public class workWithPathExamples {
    public static void main(String[] args) {
        Path testFilePath = Paths.get("C:\\Users\\Akulo\\Desktop\\TestDirectory\\log.txt");

        //  getFileName() — возвращает имя файла из пути
        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        //  getParent() — возвращает «родительскую» директорию по отношению к текущему пути (то есть ту директорию,
        //  которая находится выше по дереву каталогов)
        Path parent = testFilePath.getParent();
        System.out.println(parent);

        //   getRoot() — возвращает «корневую» директорию; то есть ту, которая находится на вершине дерева каталогов
        Path root = testFilePath.getRoot();
        System.out.println(root);

        //  startsWith(), endsWith() — проверяют, начинается/заканчивается ли путь с переданного пути
        boolean endWithTxt = testFilePath.endsWith("TestDirectory\\log.txt");   //  true
        System.out.println(endWithTxt);
        System.out.println(testFilePath.endsWith("og.txt"));    //  false

        boolean startsWithLalala = testFilePath.startsWith("lalalala"); //  false
        System.out.println(startsWithLalala);

        //  boolean isAbsolute() — возвращает true, если текущий путь является абсолютным
        System.out.println(testFilePath.isAbsolute());  //  true

        //  Path normalize() — «нормализует» текущий путь, удаляя из него ненужные элементы
        Path path5 = Paths.get("C:\\Users\\Java\\.\\examples");
        System.out.println(path5.normalize());

        Path path6 = Paths.get("C:\\Users\\Java\\..\\examples");
        System.out.println(path6.normalize());

        //  Path relativize() — вычисляет относительный путь между текущим и переданным путем
        Path testFilePath1 = Paths.get("C:\\Users\\Users\\Users\\Users");
        Path testFilePath2 = Paths.get("C:\\Users\\Users\\Users\\Users\\Username\\Desktop\\testFile.txt");
        System.out.println(testFilePath1.relativize(testFilePath2));
    }
}
