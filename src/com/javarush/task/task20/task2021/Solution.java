package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом

Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.
*/

public class Solution implements Serializable {

    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("Не сегодня");
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException("Не сегодня");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\Task2021.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        SubSolution subSolution = new SubSolution();
//        objectOutputStream.writeObject(subSolution);
//        objectOutputStream.close();
//
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\Task2021.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        SubSolution loadedSubSolution = (SubSolution) objectInputStream.readObject();
//        objectInputStream.close();
//        System.out.println(loadedSubSolution);
    }
}
