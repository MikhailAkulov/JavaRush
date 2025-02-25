package com.javarush.task.task20.extraExamples;

import java.io.*;
import java.util.Arrays;

/**
 * Сериализация - десериализация на примере игры.
 * То есть сохранение её состояния
 */
public class SerializationExample3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // создаем объект
        TerritoriesInfo territoriesInfo = new TerritoriesInfo("У Испании 6 провинций, у России 10 провинций, у Франции 8 провинций");
        ResourcesInfo resourcesInfo = new ResourcesInfo("У Испании 100 золота, у России 80 золота, у Франции 90 золота");
        DiplomacyInfo diplomacyInfo = new DiplomacyInfo("Франция воюет с Россией, Испания заняла позицию нейтралитета");

        SavedGameStatus savedGameStatus = new SavedGameStatus(territoriesInfo, resourcesInfo, diplomacyInfo);

        // создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\saveStatus.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(savedGameStatus);

        // закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        // десериализуем объект
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\saveStatus.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedGameStatus loadedGameStatus = (SavedGameStatus) objectInputStream.readObject();

        System.out.println(loadedGameStatus);
    }
}

class SavedGameStatus implements Serializable {
    private transient TerritoriesInfo territoriesInfo;
    private ResourcesInfo resourcesInfo;
    private DiplomacyInfo diplomacyInfo;

    public SavedGameStatus(TerritoriesInfo territoriesInfo, ResourcesInfo resourcesInfo, DiplomacyInfo diplomacyInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public TerritoriesInfo getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(TerritoriesInfo territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public ResourcesInfo getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(ResourcesInfo resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public DiplomacyInfo getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(DiplomacyInfo diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGameStatus{" +
                "territoriesInfo=" + territoriesInfo +
                ", resourcesInfo=" + resourcesInfo +
                ", diplomacyInfo=" + diplomacyInfo +
                '}';
    }
}

class TerritoriesInfo {
    private String info;

    public TerritoriesInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "TerritoriesInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}

class ResourcesInfo implements Serializable {
    private String info;

    public ResourcesInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResourcesInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}

class DiplomacyInfo implements Serializable {
    private String info;

    public DiplomacyInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "DiplomacyInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}