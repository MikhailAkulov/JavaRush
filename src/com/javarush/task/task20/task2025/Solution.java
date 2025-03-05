package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа

Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long) находить все числа,
удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень. getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
Метод main не участвует в тестировании.
*/

public class Solution {
    private static long S;
    private static int N;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;

    private static List<Long> results;
    private static long maxPow;
    private static long minPow;
    
    private static long[][] powers;

    public static long[] getNumbers(long upperLimit) {
        if (upperLimit <= 1) {
            return new long[0];
        }
        S = upperLimit;
        List<Long> armstrongList = generate(String.valueOf(S).length() + 1);
        long[] result = new long[armstrongList.size()];

        for (int i = 0; i < armstrongList.size(); i++) {
            result[i] = armstrongList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

    private static void genPowers(int N) {
        if (N > 20) {
            throw new IllegalArgumentException();
        }

        powers = new long[10][N + 1];
        for (int i = 0; i < powers.length; i++) {
            long p = 1;
            for (int j = 0; j < powers[i].length; j++) {
                powers[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        if (pow >= maxPow) {
            return false;
        }
        if (pow < minPow) {
            return false;
        }

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) {
                return false;
            }
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) {
                return false;
            }
        }
        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) {
            return;
        }

        if (digit == -1) {
            if (check(pow) && pow < S) {
                results.add(pow);
            }
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * powers[digit][N]);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * powers[digit][N] < minPow) {
                return;
            }

            long p = pow;
            for (int i = 0; i <= unused ; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += powers[digit][N];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }

    private static List<Long> generate(int maxNumber) {
        if (maxNumber >= 21) {
            throw new IllegalArgumentException();
        }
        genPowers(maxNumber);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        for (N = 1; N < maxNumber; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(9, N, 0);
        }
        Collections.sort(results);
        return results;
    }
}
