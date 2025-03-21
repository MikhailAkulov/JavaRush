package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21; //17
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
//        int octalNumber = 25;
//        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        if (decimalNumber > 0) {
            int octalNumber = 0;
            int i = 0;
            while (decimalNumber != 0) {
                octalNumber = (int) (octalNumber + (decimalNumber % 8) * Math.pow(10, i));
                decimalNumber = decimalNumber / 8;
                i++;
            }
            return octalNumber;
        }
        return 0;
    }

    public static int toDecimal(int octalNumber) {
        //напишите тут ваш код
        return 0;
    }
}
