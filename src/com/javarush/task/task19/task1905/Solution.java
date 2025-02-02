package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер

Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируй countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (entry.getValue().equals(customer.getCountryName())) {
                    return entry.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            // 1 вариант
//            String str = contact.getName();
//            String[] strArray = str.split(" ");
//            return strArray[1].trim();

            // 2 вариант
            String[] firstName = contact.getName().split(", ");
            return firstName[1];
        }

        @Override
        public String getContactLastName() {
            // 1 вариант
//            String str = contact.getName();
//            int zpt = str.indexOf(",");
//            return str.substring(0, zpt).trim();

            // 2 вариант
            String[] lastName = contact.getName().split(", ");
            return lastName[0];
        }

        @Override
        public String getDialString() {
            // 1 вариант
//            String result = "callto://+";
//            char[] sourceCharArray = contact.getPhoneNumber().toCharArray();
//            for (Character ch : sourceCharArray) {
//                if (Character.isDigit(ch)) {
//                    result += ch;
//                }
//            }
//            return result;

            // 2 вариант
            return "callto://+" + contact.getPhoneNumber().replaceAll("\\D", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}