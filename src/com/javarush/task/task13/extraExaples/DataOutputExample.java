package com.javarush.task.task13.extraExaples;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputExample {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("C:/Users/Akulo/Desktop/SourceDirectory/someFile.txt");
        BufferedOutputStream bufferedStream = new BufferedOutputStream(outputStream);

        String text = "I love JAVA";    // эту строку мы преобразуем в массив байтов и запишем в файл

        byte[] buffer = text.getBytes();

        bufferedStream.write(buffer, 0, buffer.length);
        bufferedStream.close();
    }
}
