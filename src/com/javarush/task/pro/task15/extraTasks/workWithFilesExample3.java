package com.javarush.task.pro.task15.extraTasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Возможности Stream API
 * Задача: найти в файле все строки, которые начинаются со слова «Как», привести их к UPPER CASE и вывести в консоль
 */
public class workWithFilesExample3 {
    public static void main(String[] args) throws IOException {

        //  Решение с использованием класса Files в Java 7
//        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\pushkin.txt"));
//        List<String> result1 = new ArrayList<>();
//        for (String str : lines) {
//            if (str.startsWith("Как")) {
//                String upper = str.toUpperCase();
//                result1.add(upper);
//            }
//        }
//        for (String s : result1) {
//            System.out.println(s);
//        }

        //  С использованием Java 8 Stream API
        Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\pushkin.txt"));

        List<String> result2 = stream
                .filter(line -> line.startsWith("Как")) //  С помощью метода filter() отбираем только те строки из файла, которые начинаются с «Как»
                .map(String::toUpperCase)   //  Проходимся по всем отобранным строкам с помощью метода map() и приводим каждую из них к UPPER CASE
                .collect(Collectors.toList());  //  Объединяем все получившиеся строки в List с помощью метода collect()
        result2.forEach(System.out::println);
    }
}
