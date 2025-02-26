package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке

Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private transient String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public Solution() {
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
//        in.close();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\Task2022.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\Task2022.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            Solution solution = new Solution("C:\\Users\\Akulo\\Desktop\\Task2022.txt");
            solution.writeObject("nothing matter");

            objectOutputStream.writeObject(solution);
            objectOutputStream.flush();

            Solution loadedObject = (Solution) objectInputStream.readObject();
            loadedObject.writeObject("nothing matter again");
        } catch (Exception ignored) {
            /* NOP */;
        }
    }
}
