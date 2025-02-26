package com.javarush.task.task20.extraExamples;

import java.io.*;

public class TishkevichExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Обычная сериализация
        FileOutputStream fileOutputStream1 = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\Tishkevich.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream1);
        Bill bill = new Bill(1L, 1000, true);
        Account savedAccount = new Account(10L, "Lori", 4, "+123456789", "account@mail.biz", bill);
        objectOutputStream.writeObject(savedAccount);
        objectOutputStream.close();

        // Способ сериализации объекта в любом виде
        // в файле уже будет читаемая информация, но по такому файлу сложнее десериализовать объект,
        // потому что нужно писать обработчик вручную
        FileOutputStream fileOutputStream2 = new FileOutputStream("C:\\Users\\Akulo\\Desktop\\Tishkevich_pretty.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream2);
        outputStreamWriter.write(savedAccount.toString());
        outputStreamWriter.close();

        // Обычная десериализация
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Akulo\\Desktop\\Tishkevich.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Account loadedAccount = (Account) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(loadedAccount);
    }
}

class Account implements Serializable {
    private static final long serialVersionUID = 6584986L;
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private transient String mail;
    private Bill bill;

    public Account(Long id, String name, Integer age, String phone, String mail, Bill bill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.mail = mail;
        this.bill = bill;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", bill=" + bill +
                '}';
    }
}

class Bill implements Serializable {
    private static final long serialVersionUID = 54898L;
    private Long id;
    private Integer amount;
    private Boolean isOverdraftEnabled;

    public Bill(Long id, Integer amount, Boolean isOverdraftEnabled) {
        this.id = id;
        this.amount = amount;
        this.isOverdraftEnabled = isOverdraftEnabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getOverdraftEnabled() {
        return isOverdraftEnabled;
    }

    public void setOverdraftEnabled(Boolean overdraftEnabled) {
        isOverdraftEnabled = overdraftEnabled;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", isOverdraftEnabled=" + isOverdraftEnabled +
                '}';
    }
}