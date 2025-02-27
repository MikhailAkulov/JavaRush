package com.javarush.task.task20.task2008;

import java.io.*;

/* 
Как сериализовать Singleton?

Два десериализованных объекта singleton и singleton1 имеют разные ссылки в памяти, а должны иметь одинаковые.
Синглтоном (Singleton) называют класс, у которого экземпляр создаётся только один раз.
Немного больше информации про синглтон можешь найти в статье.
В класс Singleton добавь приватный метод Object readResolve(), чтобы после десериализации ссылки на объекты были равны.
Метод main не участвует в тестировании.
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();

        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);

        Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);

        System.out.println("Проверка ourInstance : " + singleton.getInstance());
        System.out.println("Проверка ourInstance : " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Проверка singleton : " + singleton);
        System.out.println("Проверка singleton1 : " + singleton1);
    }

    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(instance);
        oos.close();

        return byteArrayOutputStream;
    }

    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream)
            throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        // 1 вариант
//        return (Singleton) singleton.readResolve();

        return singleton;
    }

    public static class Singleton implements Serializable {
        // 1 вариант
//        private static volatile Singleton ourInstance;
//
//        public static Singleton getInstance() {
//            if (ourInstance == null) {
//                synchronized (Singleton.class) {
//                    if (ourInstance == null) {
//                        ourInstance = new Singleton();
//                    }
//                }
//            }
//            return ourInstance;
//        }

        // 2 вариант
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }

        // 1 вариант
//        private Object readResolve() {
//            return ourInstance;
//        }

        // 2 вариант
        private Object readResolve() throws ObjectStreamException {
            return getInstance();
        }
    }
}
