package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        String hexNumber = "";
        if (decimalNumber <= 0) {
            return hexNumber;
        } else {
            while (decimalNumber != 0) {
                int index = decimalNumber % 16;
                String symbol = String.valueOf(HEX.charAt(index));
                hexNumber = symbol + hexNumber;
                decimalNumber = decimalNumber / 16;
            }
        }
        return hexNumber;
    }

    public static int toDecimal(String hexNumber) {
        int decimalNumber = 0;
        if (hexNumber == null || hexNumber.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < hexNumber.length(); i++) {
                String symbol = String.valueOf(hexNumber.charAt(i));
                int index = 0;
                for (int j = 0; j < HEX.length(); j++) {
                    String symbolHex = String.valueOf(HEX.charAt(j));
                    if (symbol.equals(symbolHex)) {
                        index = j;
                        break;
                    }
                }
                decimalNumber = 16 * decimalNumber + index;
            }
        }
        return decimalNumber;
    }
}
