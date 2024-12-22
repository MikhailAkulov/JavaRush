package com.javarush.task.task14.task1421;

public class Singleton {

    /**
     * 1 вариант
     * У этого решения есть единственный недостаток – оно не работает в многопоточной среде и поэтому
     * не подходит в большинстве случаев. Решение подходит исключительно для однопоточных приложений.
     */
//    private static Singleton instance;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 2 вариант
     * подходит для многопоточных приложений, при условии отсутствия опасности возникновения
     * исключительных ситуаций в конструкторе и отсутствии необходимости ленивой инициализации.
     */
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
