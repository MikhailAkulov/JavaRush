package com.javarush.task.task18.extraExamples;

/**
 * Допустим нам нужно перехватить вызов методов у объекта cat и, возможно, внести туда небольшие изменения.
 * Для этого нам понадобится обернуть его в свой класс-обертку.
 *
 * Если мы хотим «обернуть» вызовы методов какого-то объекта своим кодом, то нам нужно:
 * 1) Создать свой класс-обертку и унаследоваться от класса/интерфейса, для которого делаем обертку.
 * 2) Передать оборачиваемый объект в конструктор нашего класса.
 * 3) Переопределить все методы в нашем новом классе, и вызвать в них методы оборачиваемого объекта.
 * 4) Внести свои изменения «по вкусу»: менять результаты вызовов, параметры или делать что-то еще.
 * В примере ниже мы перехватываем вызов метода getName у объекта cat и немного меняем его результат.
 */
public class WrapperExample {
    public static void main(String[] args) {
        Cat cat = new Cat("Васька");
        Cat catWrap = new CatWrapper(cat);
        printName(catWrap);
    }

    public static void printName(Cat named) {
        System.out.println(named.getName());
    }
}

/**
 * Класс Кот(Cat) содержит два метода – получить имя и установить имя.
 */
class Cat {
    private String name;
    public Cat(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Класс-обертка. Класс не хранит никаких данных, кроме ссылки на оригинальный объект.
 * Класс в состоянии «пробрасывать» вызовы оригинальному объекту (setName), переданному ему в конструкторе.
 * А также «перехватывать» эти вызовы и модифицировать их параметры и результаты.
 */
class CatWrapper extends Cat {
    private Cat original;
    public CatWrapper(Cat cat) {
        super(cat.getName());
        this.original = cat;
    }
    public String getName() {
        return "Кот по имени " + original.getName();
    }
    public void setName(String name) {
        original.setName(name);
    }
}