package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов

1. Создай 4 конструктора с разными модификаторами доступа в классе Solution.
2. В отдельном файле создай класс SubSolution и сделай его потомком класса Solution.
3. Внутри класса SubSolution создай конструкторы командой Alt+Insert -> Constructors.
4. Исправь модификаторы доступа конструкторов в SubSolution так, чтобы получилось 3 разных (все, кроме private).
*/

public class Solution {

    int i;
    String s;
    long l;
    char c;

    Solution(int i) {
        this.i = i;
    }
    public Solution(String s) {
        this.s = s;
    }
    private Solution(long l) {
        this.l = l;
    }
    protected Solution(char c) {
        this.c = c;
    }

    public static void main(String[] args) {

    }
}

