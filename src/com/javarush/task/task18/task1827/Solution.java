package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    // 2 вариант
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
        // 1 вариант (валидатор не принимает)
//        if (args == null || args.length < 1) {
//            System.out.println("Аргументы не переданы");
//        } else if (args[0].equals("-c")) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            String fileName = reader.readLine();
//
//            // считали параметры нового товара
//            String productName = "";
//            String price = "";
//            String quantity = "";
//            for (int i = 1; i < args.length; i++) {
//                String currentStr = args[i];
//                char[] charArray = currentStr.toCharArray();
//                if (Character.isLetter(charArray[0])) {
//                    productName += currentStr + " ";
//                } else if (Character.isDigit(charArray[0])) {
//                    if (currentStr.contains(".")) {
//                        price = currentStr;
//                    } else  {
//                        quantity = currentStr;
//                    }
//                }
//            }
//
//            // сразу подготавливаем их к записи
//            while (productName.length() != 30) {
//                if (productName.length() < 30) {
//                    productName += " ";
//                } else {
//                    productName = productName.substring(0,30);
//                }
//            }
//            while (price.length() != 8) {
//                if (price.length() < 8) {
//                    price += " ";
//                } else {
//                    price = price.substring(0, 8);
//                }
//            }
//            while (quantity.length() != 4) {
//                if (quantity.length() < 4) {
//                    quantity += " ";
//                } else {
//                    quantity = quantity.substring(0, 4);
//                }
//            }
//
//            // считываем содержимое файла
//            String line = "";
//            int id = 0;
//            try (FileReader fileReader = new FileReader(fileName)) {
//                int c;
//                while ((c = fileReader.read()) != -1) {
//                    String currentSymbol = String.valueOf((char) c);
//                    line += currentSymbol;
//                }
//                if (line.isEmpty()) {       // если файл пустой
//                    String strId = "1       ";
//                    String result = strId + productName + price + quantity;
//                    try (FileWriter fileWriter = new FileWriter(fileName)){
//                        fileWriter.write(result);
//                    }
//
//                } else {        // если файл НЕ пустой
//                    // получаем лист с содержимым
//                    String[] strArray = line.split("\r\n");
//                    List<String> sourceList = new ArrayList<>();
//                    for (String s : strArray) {
//                        sourceList.add(s.trim());
//                    }
//
//                    // вычисляем максимальный id
//                    for (String str : sourceList) {
//                        int currentId = Integer.parseInt(str.substring(0, 8).trim());
//                        if (currentId > id) {
//                            id = currentId;
//                        }
//                    }
//
//                    id++;
//                    String strId = String.valueOf(id);
//                    while (strId.length() < 8) {
//                        strId += " ";
//                    }
//
//                    // подготавливаем данные для записи в файл и записываем
//                    try (FileWriter fileWriter = new FileWriter(fileName, true)){
//                        String result = "\r\n" + strId + productName + price + quantity;
//                        fileWriter.write(result);
//                    }
//                }
//            }
//        }

        // 2 вариант
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
                    fileWriter.write("\n");
                    fileWriter.write(product.toString());
                }
        }
    }

    // 2 вариант
    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}

// C:\Users\Akulo\Desktop\SourceDirectory\sourceFileCRUD.txt