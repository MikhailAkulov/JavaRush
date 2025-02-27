package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов

Давай представим ситуацию, что с одной стороны у нас есть некая база данных, в которой хранятся данные.
База данных имеет стандартный набор команд (методов) для предоставления данных, они описаны в интерфейсе IncomeData.
Примеры представления данных приведены в комментариях около каждого метода.

С другой стороны есть пользователи, которые хотят получать данные из этой базы,
но в каком-то другом (конкретном) формате.
Запросы от пользователей представлены методами в интерфейсах Customer и Contact.
Там же (в комментариях около каждого метода) есть примеры представления информации в том виде,
в котором пользователи хотят ее получать из базы данных.

Твоя задача: написать логику класса адаптера IncomeDataAdapter, который будет по запросам методов
из интерфейсов Customer и Contact, обращаться в базу (методы интерфейса IncomeData), получать данные,
обрабатывать их, при необходимости изменять представление, и возвращать в виде результата.

Инициализируй countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada

При необходимости дополни начало телефонного номера (без кода страны) нулями
до 10 цифр (смотри примеры в комментарии к соответствующему методу).
Обрати внимание на формат вывода телефона, фамилии и имени человека
(смотри примеры в комментарии к соответствующему методу).
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

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
//            return data.getContactLastName() + ", " + data.getContactFirstName();
            return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            // 1 вариант
            String strCountryPhoneCode = String.valueOf(data.getCountryPhoneCode());
            String strPhoneNumber = String.valueOf(data.getPhoneNumber());
            while (strPhoneNumber.length() < 10) {
                strPhoneNumber = "0" + strPhoneNumber;
            }
            String strCityCode = strPhoneNumber.substring(0, 3);
            String strPhoneNumberPart1 = strPhoneNumber.substring(3, 6);
            String strPhoneNumberPart2 = strPhoneNumber.substring(6, 8);
            String strPhoneNumberPart3 = strPhoneNumber.substring(8);
            return String.format("+%s(%s)%s-%s-%s", strCountryPhoneCode, strCityCode, strPhoneNumberPart1,
                    strPhoneNumberPart2, strPhoneNumberPart3);

            // 2 вариант
//            String result = String.format("+%d(%2$s)%3$s-%4$s-%5$s", data.getCountryPhoneCode(),
//                    String.format("%010d", data.getPhoneNumber()).substring(0, 3),
//                    String.format("%010d", data.getPhoneNumber()).substring(3, 6),
//                    String.format("%010d", data.getPhoneNumber()).substring(6, 8),
//                    String.format("%010d", data.getPhoneNumber()).substring(8));
//            return result;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}