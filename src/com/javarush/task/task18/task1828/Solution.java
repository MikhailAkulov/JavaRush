package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2

CRUD для таблицы внутри файла.
Напиши программу, которая считывает с консоли путь к файлу для операций CRUD и при запуске в зависимости от флага,
переданного в параметрах обновляет данные товара с заданным id или производит физическое удаление товара с заданным id
(удаляет из файла все данные, которые относятся к переданному id).
-u id productName price quantity
-d id

Значения параметров:
-u - флаг, который означает обновление данных товара с заданным id
-d - флаг, который означает физическое удаление товара с заданным id
(из файла удаляются все данные, которые относятся к переданному id)
id - id товара, 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Для чтения и записи файла нужно использовать FileReader и FileWriter соответственно.

Пример содержимого файла:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                Product product = getProduct(fileReader.readLine());
                products.add(product);
            }
        }

        boolean fileHaveData;
        if (products.isEmpty()) {
            fileHaveData = false;
        } else {
            fileHaveData = true;
        }

        switch (args[0]) {
            case "-c":
                int id = 0;
                for (Product product : products) {
                    if (product.id > id) {
                        id = product.id;
                    }
                }
                String name = "";
                for (int i = 1; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                }
                String price = args[args.length - 2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length - 1];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                Product product = new Product(++id, name.trim(), price, quantity);
                try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                    if (fileHaveData) {
                        fileWriter.write("\n");
                        fileWriter.write(product.toString());
                    } else {
                        fileWriter.write(product.toString());
                    }
                }
                break;
            case "-d":
                if (!fileHaveData) {
                    System.out.println("Файл пуст, нет данных для удаления");
                } else {
                    int idForDeleted = Integer.parseInt(args[1]);
                    for (int i = 0; i < products.size(); i++) {
                        Product currentProduct = products.get(i);
                        if (currentProduct.id == idForDeleted) {
                            products.remove(currentProduct);
                        }
                    }
                    try (FileWriter fileWriter = new FileWriter(fileName)) {
                        for (int i = 0; i < products.size(); i++) {
                            Product currentProduct = products.get(i);
                            if (i < products.size() - 1) {
                                fileWriter.write(currentProduct.toString());
                                fileWriter.write("\n");
                            } else {
                                fileWriter.write(currentProduct.toString());
                            }
                        }
                    }
                }
                break;
            case "-u":
                int idForRefresh = Integer.parseInt(args[1]);
                int index = -1;
                for (Product p : products) {
                    if (p.id == idForRefresh) {
                        idForRefresh = p.id;
                        index = products.indexOf(p);
                    }
                }
                String nameForRefresh = "";
                for (int i = 2; i < args.length - 2; i++) {
                    nameForRefresh += args[i] + " ";
                }
                if (nameForRefresh.length() > 30) {
                    nameForRefresh = nameForRefresh.substring(0, 30);
                }
                String priceForRefresh = args[args.length - 2];
                if (priceForRefresh.length() > 8) {
                    priceForRefresh = priceForRefresh.substring(0, 8);
                }
                String quantityForRefresh = args[args.length - 1];
                if (quantityForRefresh.length() > 4) {
                    quantityForRefresh = quantityForRefresh.substring(0, 4);
                }
                Product productForRefresh = new Product(idForRefresh, nameForRefresh.trim(), priceForRefresh, quantityForRefresh);
                products.set(index, productForRefresh);
                try (FileWriter fileWriter = new FileWriter(fileName)) {
                    for (int i = 0; i < products.size(); i++) {
                        Product currentProduct = products.get(i);
                        if (i < products.size() - 1) {
                            fileWriter.write(currentProduct.toString());
                            fileWriter.write("\n");
                        } else {
                            fileWriter.write(currentProduct.toString());
                        }
                    }
                }
                break;
        }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\sourceFileCRUD.txt
// -c Каска для сноубордистов, размером с дом 512.00 32
// -d 19847985
// -u 19847987 Каска для лыжников с проблесковым маячком 1024.99 128
// -u 3 Каска для лыжников с проблесковым маячком 1024.99 128