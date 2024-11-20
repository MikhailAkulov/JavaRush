package com.javarush.task.pro.task05.task0510;

/* 
Треугольный массив
*/

import java.util.Arrays;

public class Solution {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i+1];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = i + j;
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
//        result[0] = new int[]{0};
//        result[1] = new int[]{1, 2};
//        result[2] = new int[]{2, 3, 4};
//        result[3] = new int[]{3, 4, 5, 6};
//        result[4] = new int[]{4, 5, 6, 7, 8};
//        result[5] = new int[]{5, 6, 7, 8, 9, 10};
//        result[6] = new int[]{6, 7, 8, 9, 10, 11, 12};
//        result[7] = new int[]{7, 8, 9, 10, 11, 12, 13, 14};
//        result[8] = new int[]{8, 9, 10, 11, 12, 13, 14, 15, 16};
//        result[9] = new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
//
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
