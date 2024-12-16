package com.javarush.task.task13.extraExaples;

import java.io.*;

public class BufferedInputExample {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        BufferedInputStream buffer = null;

        try {
            inputStream = new FileInputStream("C:/Users/Akulo/Desktop/SourceDirectory/sourceFile.txt");
            buffer = new BufferedInputStream(inputStream);

            while (buffer.available() > 0) {
                char c = (char) buffer.read();
                System.out.println("Был прочитан символ: " + c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            buffer.close();
        }
    }
}
