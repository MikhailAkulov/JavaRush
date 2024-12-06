package com.javarush.task.pro.task13.Extra;

import java.util.*;

public class noMoreLoops {
    public static void main(String[] args) {
        //  1. Iterable.forEach(Consumer<? super T> action)
        //  Перебирает переданную коллекцию, и выполняет лямбда-выражение action для каждого ее элемента.
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        numbers.forEach(s -> System.out.print(s + " "));
        System.out.println("\n"+"_______________^1^________________");

        //  2. Collection.removeIf(Predicate<? super E> filter)
        //  Метод перебирает коллекцию, и удаляет те элементы, которые соответствуют filter.
        numbers.removeIf(s -> s > 5);
        numbers.forEach(s -> System.out.print(s + " "));
        System.out.println("\n"+"_______________^2^________________");

        //  3. Map.forEach(BiConsumer<? super K, ? super V> action)
        //  Метод forEach работает не только для классов, реализующих интерфейс Collection, но и для Map.
        Map<String, String> books = new HashMap<>();
        books.put("Война и мир", "Лев Толстой");
        books.put("Преступление и наказание", "Федор Достоевский");
        books.put("Философия Java", "Брюс Эккель");
        books.put("Братья Карамазовы", "Федор Достоевский");
        books.put("Властелин Колец", "Джон Толкин");
        books.forEach((a,b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
        System.out.println("_______________^3^________________");

        //  4. Map.compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        //  Для указанного ключа key этот метод устанавливает в качестве value результат выполнения функции remappingFunction.
        books.compute("Философия Java", (a,b) -> b + ", крутой чувак");
        books.forEach((a,b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
        System.out.println("_______________^4^________________");

        //  5. Map.computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
        //  Метод добавит новый элемент в Map, но только в том случае, если элемент с таким ключом там отсутствует.
        //  В качестве value ему будет присвоен результат выполнения функции mappingFunction.
        //  Если же элемент с таким ключом уже есть — он не будет перезаписан, а останется на месте.
        books.computeIfAbsent("Гарри Поттер и узник Азкабана", b -> getHarryPotterAuthor());
        books.forEach((a,b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
        System.out.println("_______________^5^________________");

        //  6. Map.computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        //  Тот же принцип, что и у Map.compute(), но все вычисления будут выполнены только в случае, если элемент с ключом key уже существует.
        books.computeIfPresent("Евгений Онегин", (a,b) -> b = "Александр Пушкин");
        books.forEach((a,b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
        books.computeIfPresent("Братья Карамазовы", (a,b) -> b = "Александр Пушкин");
        System.out.println("_______________^6^________________");
        books.forEach((a,b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
        System.out.println("_______________^6^________________");

        //  7. Map.getOrDefault(Object key, V defaultValue)
        //  Возвращает значение, соответствующее ключу key. Если такой ключ не существует — возвращает значение по умолчанию.
        String igor = books.getOrDefault("Слово о полку Игореве", "Неизвестный автор");
        System.out.println(igor);
        System.out.println("_______________^7^________________");

        //  8. Map.merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
        //  Если в вашей Map ключ key не существует, или value для этого ключа равно null — метод добавляет в Map переданную пару key-value.
        //  Если ключ Key существует и его value != null — метод меняет его value на результат выполнения переданной функции remappingFunction.
        //  Если remappingFunction возвращает null - key удаляется из коллекции.
        books.merge("Философия Java", "Брюс Эккель", (a, b) -> b +  " и кто-то там еще");
        books.forEach((a,b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
        System.out.println("_______________^8^________________");

        //  9. Map.putIfAbsent(K key, V value)
        //  добавить пару в Map, если ее там нет
        books.putIfAbsent("Властелин Колец", "Джон Толкин");
        books.forEach((a,b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
        System.out.println("_______________^9^________________");

        //  10. Map.replace и Map.replaceAll()
        //  Map.replace(K key, V newValue — заменяет значение ключа key на newValue, если такой ключ существует. Если нет — ничего не происходит.
        //  Map.replace(K key, V oldValue, V newValue) — делает то же самое, но только если текущее значение key равно oldValue.
        //  Map.replaceAll(BiFunction<? super K, ? super V, ? extends V> function) — заменяет все значения value на результат выполнения функции function.
        books.replace("Братья Карамазовы", "Александр Пушкин", "Федор Достоевский");
        books.forEach((a,b) -> System.out.println("Название:" + a + ". Автор: " + b));
        System.out.println("_______________^10^_______________");
        books.replaceAll((a,b) -> getCoolWriter());
        books.forEach((a,b) -> System.out.println("Название:" + a + ". Автор: " + b));
        System.out.println("_______________^10^_______________");
    }

    //  функция mappingFunction для 10-го примера.
    public static String getCoolWriter() {
        return "Крутой писатель";
    }

    //  функция mappingFunction для 5-го примера.
    public static String getHarryPotterAuthor() {
        return "Джоан Роулинг";
    }
}
