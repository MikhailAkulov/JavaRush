package com.javarush.task.task15.task1524;

/* 
Порядок загрузки переменных

Разберись, что и в какой последовательности инициализируется в этой программе, а затем:
1. Поставь брейкпойнты и используй дебаггер.
2. Исправь порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
Non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
*/

public class Solution {
    {
        System.out.println("Non-static block");
        printAllFields(this);
    }

    static {
        init();
    }

    public int i = 6;

    public String name = "First name";

    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    static {
        System.out.println("Static block");
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);
    }
}
