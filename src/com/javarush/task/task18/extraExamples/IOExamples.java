package com.javarush.task.task18.extraExamples;

import java.io.*;

public class IOExamples {
    public static void main(String[] args) throws IOException {

        /**
         * Пример 1
         */
        // Вывод строки на консоль
        System.out.println("Hello");

        // Сохранили поток вывода на консоль в отдельную переменную. Выводим в поток строку.
        PrintStream console = System.out;
        console.println("Hello2");

        // Создали динамический (растягивающийся) массив байт в памяти.
        // Связали его с новым потоком вывода – объектов PrintStream
        // Выводим в поток строку.
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream console2 = new PrintStream(stream);
        console2.println("Hello3");


        /**
         * Пример 2
         * Подсчет суммы всех байт файла на диске
         */
        // создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\pushkin.txt");
        long sum = 0;

        while (inputStream.available() > 0) {       // пока остались непрочитанные байты
            int data = inputStream.read();          // прочитать очередной байт
            sum += data;                            // добавить его к общей сумме
        }
        inputStream.close();                        // закрываем поток

        System.out.println(sum);                    //выводим сумму на экран.

        /**
         * Пример 3
         * Копируем файл на диске
         */
        //Создаем поток-чтения-байт-из-файла
        FileInputStream fis = new FileInputStream("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\pushkin.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\pushkin-copy.txt");

        while (fis.available() > 0) {       // пока есть еще непрочитанные байты
            int data = fis.read();          // прочитать очередной байт в переменную data
            fos.write(data);                // и записать его во второй поток
        }

        fis.close();                        // закрываем оба потока. Они больше не нужны.
        fos.close();
    }
}
