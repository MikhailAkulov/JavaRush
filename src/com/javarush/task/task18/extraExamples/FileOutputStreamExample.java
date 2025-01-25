package com.javarush.task.task18.extraExamples;

import java.io.FileOutputStream;
import java.io.IOException;

// Запись байтов в файл

public class FileOutputStreamExample {
    public static void main(String[] args) throws IOException {
        // при повторном запуске кода, информация будет перезаписываться.
//        File file = new File("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\testFile.txt");
//
//        String greetings = "Привет! Добро пожаловать на JavaRush - лучший сайт для тех, кто хочет стать программистом!";
//
//        fileOutputStream.write(greetings.getBytes());
//        fileOutputStream.close();

        // Если нужно дополнять информацию в конец файла.
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\testFile.txt", true);

        String greetings = "Привет! Добро пожаловать на JavaRush - лучший сайт для тех, кто хочет стать программистом!\r\n";

        fileOutputStream.write(greetings.getBytes());
        fileOutputStream.close();
    }
}
