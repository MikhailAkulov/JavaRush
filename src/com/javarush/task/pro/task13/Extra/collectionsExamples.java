package com.javarush.task.pro.task13.Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class collectionsExamples {
    public static void main(String[] args) {
        String mercury = new String("Меркурий");
        String venus = new String("Венера");
        String earth = new String("Земля");
        String mars = new String("Марс");
        String jupiter = new String("Юпитер");
        String saturn = new String("Сатурн");
        String uranus = new String("Уран");
        String neptune = new String("Нептун");

        // max и min
//        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
//        System.out.println(Collections.max(numbers));
//        System.out.println(Collections.min(numbers));

        // sort
//        ArrayList<String> solarSystem = new ArrayList<>(Arrays.asList(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune));
//        Collections.sort(solarSystem);
//        System.out.println(solarSystem);

        // reverse
//        Collections.reverse(solarSystem);
//        System.out.println(solarSystem);

        // shuffle
//        ArrayList<Integer> lottery = new ArrayList<>(100);
//        for (int i = 0; i <= 100; i++) {
//            lottery.add(i);
//        }
//        Collections.shuffle(lottery);
//        System.out.println("Внимание! Из барабаа появляются первые 10 чисел!");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(lottery.get(i));
//        }

        // unmodifiableList - неизменяемый список
//        List<String> solarSystem = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune)));
//        solarSystem.add("Плутон");  // UnsupportedOperationException

        // swap
//        ArrayList<String> solarSystem = new ArrayList<>(Arrays.asList(neptune, venus, earth, mars, jupiter, saturn,
//                uranus, mercury));      // неправиольный порядок
//        System.out.println(solarSystem);
//        Collections.swap(solarSystem, solarSystem.indexOf(mercury), solarSystem.indexOf(neptune));
//        System.out.println(solarSystem);

        // disjoint - проверяет пересечения коллекций
        ArrayList<String> solarSystemPart1 = new ArrayList<>(Arrays.asList(mercury, venus, earth, mars));
        ArrayList<String> solarSystemPart2 = new ArrayList<>(Arrays.asList(jupiter, saturn, uranus, neptune));
        System.out.println(Collections.disjoint(solarSystemPart1, solarSystemPart2));
    }
}
