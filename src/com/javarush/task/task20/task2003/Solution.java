package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties

В методе main() происходит считывание пути к файлу с консоли и заполнение runtimeStorage данными из файла.
Тебе необходимо в методе save() реализовать логику записи в файл для карты runtimeStorage,
а в методе load() - логику чтения из файла для runtimeStorage.
Файл должен быть в формате .properties.
Комментарии в файле игнорируй.
Про .properties прочитай в вики.
Подсказка: используй объект класса Properties.
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код

        // 1 вариант (не принял валидатор)
//        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
//            Properties properties = new Properties();
//            outputStream.write((Integer) properties.setProperty(entry.getKey(), entry.getValue()));
//        }

        // 2 вариант
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            properties.setProperty(entry.getKey(), entry.getValue());
        }
        properties.store(outputStream, null);
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код

        // 1 вариант (не принял валидатор)
//        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream))){
//            String currentLine;
//            while ((currentLine = fileReader.readLine()) != null) {
//                String[] strArray = currentLine.split("=");
//                runtimeStorage.put(strArray[0].trim(), strArray[1].trim());
//            }
//        }

        // 2 вариант
        Properties properties = new Properties();
        properties.load(inputStream);

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            runtimeStorage.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}

//  C:\Users\Akulo\Desktop\SourceDirectory\task2003.properties