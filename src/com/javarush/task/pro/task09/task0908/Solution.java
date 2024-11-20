package com.javarush.task.pro.task09.task0908;

import java.util.Scanner;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        final String HEX = "0123456789abcdef";
        String hexNumber = "";
        if (binaryNumber == null || binaryNumber.isEmpty()) {
            return hexNumber;
        }

        for (int i = 0; i < binaryNumber.length(); i++) {
            int value = Character.getNumericValue(binaryNumber.charAt(i));
            if (value != 0 && value != 1) {
                return hexNumber;
            }
        }

        while (binaryNumber.length() % 4 != 0) {
            String extraStr = "0";
            binaryNumber = extraStr + binaryNumber;
        }

        for (int i = 0; i < binaryNumber.length(); ) {
            String binaryNumberStr = binaryNumber.substring(i, i + 4);
            i += 4;
            int hexIndex = 0;
            for (int j = 0; j < binaryNumberStr.length(); j++) {
                int index = binaryNumberStr.length()-1 - j;
                int value = Character.getNumericValue(binaryNumberStr.charAt(index));
                hexIndex += (int) (value * Math.pow(2, j));
            }
            char hexSymbol = HEX.charAt(hexIndex);
            hexNumber += hexSymbol;
        }
        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        final String HEX = "0123456789abcdef";
        int decimalNumber = 0;
        String binaryNumber = "";
        if (hexNumber == null || hexNumber.isEmpty()) {
            return binaryNumber;
        }

        for (int i = 0; i < hexNumber.length(); i++) {
            String str = String.valueOf(hexNumber.charAt(i));
            if (!HEX.contains(str)) {   //  .toLowerCase()
                return binaryNumber;
            }
        }

        for (int i = hexNumber.length()-1; i >= 0 ; i--) {
            decimalNumber = HEX.indexOf(hexNumber.charAt(i));
            String symbol;
            int ostatok;
            for (int j = 0; j < 4; j++) {
                ostatok = (decimalNumber % 2);
                decimalNumber = decimalNumber / 2;
                symbol = String.valueOf(ostatok);
                binaryNumber = symbol + binaryNumber;
            }
        }
        return binaryNumber;
    }
}
