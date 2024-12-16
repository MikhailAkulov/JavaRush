package com.javarush.task.task13.extraExaples;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Запись объекта MyClass в файл
 */
public class Example1 {
    public static void main(String[] args) throws IOException {
        MyClass myObject = new MyClass();
        OutputStream outStream = new FileOutputStream("C:/Users/Akulo/Desktop/SourceDirectory/my-object-data.txt");
        while (myObject.available() > 0) {
            int data = myObject.read();     //  читаем один int из потока для чтения
            outStream.write(data);          //  записываем прочитанный int в другой поток.
        }

        outStream.close();      //  закрываем потоки

        /**
         * Чтение объекта MyClass из файла
         */
        InputStream inStream = new FileInputStream("C:/Users/Akulo/Desktop/SourceDirectory/my-object-data.txt");

        while (inStream.available() > 0) {
            int data = inStream.read();     //  читаем один int из потока для чтения
            myObject.write(data);           //  записываем прочитанный int в другой поток.
        }

        inStream.close();       //  закрываем потоки
    }
}

class MyClass {
    private List<Integer> list = new ArrayList<>(Arrays.asList(111, 222, 333));

    public void write(int data) {
        list.add(data);
    }

    public int read() {
        int first = list.get(0);
        list.remove(0);
        return first;
    }

    public int available() {
        return list.size();
    }
}