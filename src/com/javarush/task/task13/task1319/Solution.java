package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

/**
 * В этой задаче нужно:
 * Прочесть с консоли имя файла.
 * Считывать строки с консоли, пока пользователь не введет строку "exit".
 * Записать абсолютно все введенные в п.2 строки в файл: каждую строчку — с новой строки.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destinationFileName = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName));
        StringBuilder builder = new StringBuilder();

        String currentStr = "";
        while (!currentStr.equals("exit")) {
            currentStr = reader.readLine();
            builder.append(currentStr).append("\n");
        }
        writer.write(builder.toString());
        writer.close();
        // C:\Users\Akulo\Desktop\SourceDirectory\testFile2.txt
    }
}
