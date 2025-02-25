package com.javarush.task.task20.extraExamples;

import java.io.*;
import java.util.Base64;

public class ExternalizableExample2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // сериализуем
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        UserInfo userInfo = new UserInfo("Ivan", "Ivanov", "Ivan Ivanov's passport data");

        objectOutputStream.writeObject(userInfo);
        objectOutputStream.close();

        // десериализуем
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        UserInfo userLoadedInfo = (UserInfo) objectInputStream.readObject();
        System.out.println(userLoadedInfo);
        objectInputStream.close();
    }
}

class UserInfo implements Externalizable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String superSecretInformation;

    public UserInfo() {
    }

    public UserInfo(String firstName, String lastName, String superSecretInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superSecretInformation = superSecretInformation;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getFirstName());
        out.writeObject(this.getLastName());
        out.writeObject(this.encryptString(this.getSuperSecretInformation()));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = (String) in.readObject();
        lastName = (String) in.readObject();
        superSecretInformation = this.decryptString((String) in.readObject());
    }

    private String encryptString(String data) {
        String encryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println(encryptedData);
        return encryptedData;
    }

    private String decryptString(String data) {
        String decrypted = new String(Base64.getDecoder().decode(data));
        System.out.println(decrypted);
        return decrypted;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuperSecretInformation() {
        return superSecretInformation;
    }

    public void setSuperSecretInformation(String superSecretInformation) {
        this.superSecretInformation = superSecretInformation;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", superSecretInformation='" + superSecretInformation + '\'' +
                '}';
    }
}