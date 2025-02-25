package com.javarush.task.task20.extraExamples;

import java.io.*;
import java.util.Arrays;

/**
 * Сериализация - десериализация на примере игры.
 * То есть сохранение её состояния
 */
public class SerializationExample2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // создаем объект
        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};

        SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);

        // создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(savedGame);

        // закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        // десериализуем объект
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedGame loadedGame = (SavedGame) objectInputStream.readObject();

        System.out.println(loadedGame);
    }
}


/**
 * Три массива данных отвечают за информацию о территориях, экономике и дипломатии,
 * а интерфейс Serializable говорит Java-машине: «все ок, если что, объекты этого класса можно сериализовать».
 */
class SavedGame implements Serializable {
//    private static final long serialVersionUID = 1L;    // уникальный идентификатор версии сериализованного класса.

    private String[] territoriesInfo;
    private String[] resourcesInfo;
    private String[] diplomacyInfo;

    public SavedGame(String[] territoriesInfo, String[] resourcesInfo, String[] diplomacyInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public String[] getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(String[] territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public String[] getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(String[] resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public String[] getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(String[] diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "territoriesInfo=" + Arrays.toString(territoriesInfo) +
                ", resourcesInfo=" + Arrays.toString(resourcesInfo) +
                ", diplomacyInfo=" + Arrays.toString(diplomacyInfo) +
                '}';
    }
}