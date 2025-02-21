package com.javarush.task.task20.extraExamples;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) throws Exception {
        Hamster hamster = new Hamster();

        // save hamster to file
        FileOutputStream fileOutputStream = new FileOutputStream("hamster.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(hamster);
        fileOutputStream.close();
        objectOutputStream.close();

        // load hamster from file
        FileInputStream fileInputStream = new FileInputStream("hamster.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        Hamster newHamster = (Hamster) object;
    }
}

class Hamster implements Serializable {
    public String name;
    public int age;
    public int weight;
}