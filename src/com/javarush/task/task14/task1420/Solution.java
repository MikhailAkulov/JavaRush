package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        // 1 вариант
//        int min = Math.min(a, b);
//        int gcd = 1;
//        for (int i = 2; i <= min; i++) {
//            if (a % i == 0 && b % i == 0)
//                gcd = i;
//        }
//        System.out.println(gcd);

        // 2 вариант
        System.out.println(getNOD(a, b));
    }

    // 2 вариант
    private static int getNOD(int first, int second) {
        if (first < 1 || second < 1) {
            throw new IllegalArgumentException();
        }

        while (first != second) {
            if (first > second) {
                first -= second;
            }
            if (second > first) {
                second -= first;
            }
        }
        return first;
    }
}
