package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix(2, 3, 2);
        printMatrix(2, 3, 2.4);
        printMatrix(2, 3, 'U');
        printMatrix(2, 3, (byte) 3);
        printMatrix(2, 3, (short) 5);
        printMatrix(2, 3, 2.8f);
        printMatrix(2, 3, 256L);
        printMatrix(2, 3, true);
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("1 - Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, int value) {
        System.out.println("2 - Заполняем объектами int");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, double value) {
        System.out.println("3 - Заполняем объектами double");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, char value) {
        System.out.println("4 - Заполняем объектами char");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, byte value) {
        System.out.println("5 - Заполняем объектами byte");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, short value) {
        System.out.println("6 - Заполняем объектами short");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, float value) {
        System.out.println("7 - Заполняем объектами float");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, long value) {
        System.out.println("8 - Заполняем объектами long");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, boolean value) {
        System.out.println("9 - Заполняем объектами boolean");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
