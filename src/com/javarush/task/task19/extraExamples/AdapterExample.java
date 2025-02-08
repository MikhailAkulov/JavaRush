package com.javarush.task.task19.extraExamples;

public class AdapterExample {
    public static void main(String[] args) {
        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();

        /**
         * Вывод в консоль:
         * Карта памяти успешно вставлена!
         * Данные скопированы на компьютер!
         */
    }
}

/**
 * Интерфейс USB с единственным методом — вставить USB-кабель
 */
interface USB {
    void connectWithUsbCable();
}

/**
 * Класс, реализующий карту памяти.
 * В нем уже есть 2 нужных метода, но интерфейс USB он не реализует.
 * Карту нельзя вставить в USB-разъем.
 */
class MemoryCard {
    public void insert() {
        System.out.println("Карта памяти успешно вставлена!");
    }

    public void copyData() {
        System.out.println("Данные скопированы на компьютер!");
    }
}

/**
 * Адаптер
 */
class CardReader implements USB {
    private MemoryCard memoryCard;

    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyData();
    }
}