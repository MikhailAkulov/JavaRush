package com.javarush.task.pro.task18.extraExamples.animalsLoversClub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Есть клуб любителей животных. Завтра у них день «рыжего кота». В клубе есть владельцы животных,
 * у каждого из которых есть список питомцев. Это могут быть не только коты.
 *
 * Задача: нужно выбрать имена всех рыжих котов, чтобы на завтра распечатать для них именные поздравительные открытки
 * с «Профессиональным праздником». Открытки должны быть отсортированы по возрасту кота: от более старого до более молодого.
 */

public class Selector {
    private static List<Owner> owners;

    public static void main(String[] args) {
        initData();

        /**
         * код, не использующий стримы для решения этой задачи:
         */
//        List<String> findNames = new ArrayList<>();
//        List<Cat> findCats = new ArrayList<>();
//        for (Owner owner : owners) {
//            for (Animal pet : owner.getPets()) {
//                if (Cat.class.equals(pet.getClass()) && Color.FOXY == pet.getColor()) {
//                    findCats.add((Cat) pet);
//                }
//            }
//        }
//
//        Collections.sort(findCats, new Comparator<Cat>() {
//            @Override
//            public int compare(Cat o1, Cat o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });
//
//        for (Cat cat : findCats) {
//            findNames.add(cat.getName());
//        }

        /**
         * Stream
         */
        final List<String> findNames = owners.stream()
                .flatMap(owner -> owner.getPets().stream())         // переход от Stream<Owner> к Stream<Pet>
                .filter(pet -> Cat.class.equals(pet.getClass()))    // в потоке данных оставляем только котов
                .filter(cat -> Color.FOXY == cat.getColor())        // в потоке данных оставляем только рыжих
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())      // сортируем по возрасту в убывающем порядке
                .map(Animal::getName)                               // берем имена
                .collect(Collectors.toList());                      // результат складываем в список

        findNames.forEach(System.out::println);


    }

    private static void initData() {
        final Owner owner1 = new Owner("Филипп Дж. Фрай");
        owner1.getPets().addAll(List.of(
                new Cat("Барон", Color.BLACK, 3),
                new Cat("Султан", Color.DARK_GREY, 4),
                new Dog("Эльза", Color.WHITE, 0)
        ));

        final Owner owner2 = new Owner("Доктор Зойдберг");
        owner2.getPets().addAll(List.of(
                new Cat("Рыжик", Color.FOXY, 7),
                new Cat("Барсик", Color.FOXY, 5),
                new Parrot("Адмирал", Color.BLUE, 3)
        ));

        final Owner owner3 = new Owner("Бендер");
        owner3.getPets().addAll(List.of(
                new Dog("Арнольд", Color.FOXY, 3),
                new Pig("Пылесос", Color.LIGHT_GREY, 8)
        ));

        final Owner owner4 = new Owner("Профессор Фарнсворт");
        owner4.getPets().addAll(List.of(
                new Snake("Удав", Color.DARK_GREY, 2)
        ));

        final Owner owner5 = new Owner("Туранга Лила");
        owner5.getPets().addAll(List.of(
                new Cat("Зубастик", Color.BLACK, 16),
                new Cat("Зорро", Color.FOXY, 14),
                new Cat("Марго", Color.WHITE, 3),
                new Cat("Забияка", Color.DARK_GREY, 1)
        ));

        owners = List.of(owner1, owner2, owner3, owner4, owner5);
    }
}
