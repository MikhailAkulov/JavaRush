package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы

CRUD для таблицы внутри файла.
Напиши программу, которая считывает с консоли путь к файлу для операций CRUD и при запуске
со следующим набором параметров:
-c productName price quantity
добавляет товар с заданными параметрами с новой строки в конец файла, генерируя id (8 символов)
самостоятельно путем инкремента максимального id, найденного в файле.

Значения параметров:
-c - флаг, который означает добавления товара.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Для чтения и записи файла нужно использовать FileReader и FileWriter соответственно.

Пример содержимого файла:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.99123
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1 вариант (валидатор не принимает)
        if (args == null || args.length < 1) {
            System.out.println("Аргументы не переданы");
        } else if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            // считали параметры нового товара
            String productName = "";
            String price = "";
            String quantity = "";
            for (int i = 1; i < args.length; i++) {
                String currentStr = args[i];
                char[] charArray = currentStr.toCharArray();
                if (Character.isLetter(charArray[0])) {
                    productName += currentStr + " ";
                } else if (Character.isDigit(charArray[0])) {
                    if (currentStr.contains(".")) {
                        price = currentStr;
                    } else  {
                        quantity = currentStr;
                    }
                }
            }

            // сразу подготавливаем их к записи
            while (productName.length() != 30) {
                if (productName.length() < 30) {
                    productName += " ";
                } else {
                    productName = productName.substring(0,30);
                }
            }
            while (price.length() != 8) {
                if (price.length() < 8) {
                    price += " ";
                } else {
                    price = price.substring(0, 8);
                }
            }
            while (quantity.length() != 4) {
                if (quantity.length() < 4) {
                    quantity += " ";
                } else {
                    quantity = quantity.substring(0, 4);
                }
            }

            // считываем содержимое файла
            String line = "";
            int id = 0;
            try (FileReader fileReader = new FileReader(fileName)) {
                int c;
                while ((c = fileReader.read()) != -1) {
                    String currentSymbol = String.valueOf((char) c);
                    line += currentSymbol;
                }
                if (line.isEmpty()) {       // если файл пустой
                    String strId = "1       ";
                    String result = strId + productName + price + quantity;
                    try (FileWriter fileWriter = new FileWriter(fileName)){
                        fileWriter.write(result);
                    }

                } else {        // если файл НЕ пустой
                    // получаем лист с содержимым
                    String[] strArray = line.split("\r\n");
                    List<String> sourceList = new ArrayList<>();
                    for (String s : strArray) {
                        sourceList.add(s.trim());
                    }

                    // вычисляем максимальный id
                    for (String str : sourceList) {
                        int currentId = Integer.parseInt(str.substring(0, 8).trim());
                        if (currentId > id) {
                            id = currentId;
                        }
                    }

                    id++;
                    String strId = String.valueOf(id);
                    while (strId.length() < 8) {
                        strId += " ";
                    }

                    // подготавливаем данные для записи в файл и записываем
                    try (FileWriter fileWriter = new FileWriter(fileName, true)){
                        String result = "\r\n" + strId + productName + price + quantity;
                        fileWriter.write(result);
                    }
                }
            }
        }
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\sourceFileCRUD.txt