package com.javarush.task.task13.task1327;

import java.util.ArrayList;
import java.util.List;

/* 
Репка

Напиши программу по мотивам сказки "Репка":
1. Реализуй интерфейс RepkaItem в классе Person.
2. В классе Person реализуй метод pull(Person person), который выводит фразу типа '<name> за <person>'.
Пример:
Бабка за Дедку
Дедка за Репку
3. Исправь логическую ошибку цикла в методе tell класса RepkaStory.
4. Выполни метод main и наслаждайся сказкой!
*/

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }
}
