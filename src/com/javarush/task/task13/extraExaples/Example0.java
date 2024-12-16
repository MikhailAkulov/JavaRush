package com.javarush.task.task13.extraExaples;

import java.io.*;

/**
 * Пример копирования данных из одного файла в другой
 */
public class Example0 {
    public static void main(String[] args) throws IOException {
        InputStream inStream = new FileInputStream("C:/Users/Akulo/Desktop/SourceDirectory/sourceFile.txt");
        OutputStream outStream = new FileOutputStream("C:/Users/Akulo/Desktop/SourceDirectory/resultFile.txt");

        while (inStream.available() > 0) {
            int data = inStream.read();     //  читаем один байт из потока для чтения
            outStream.write(data);          //  записываем прочитанный байт в другой поток.
        }

        //закрываем потоки
        inStream.close();
        outStream.close();
    }
}
