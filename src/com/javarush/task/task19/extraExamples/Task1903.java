package com.javarush.task.task19.extraExamples;

public class Task1903 {
    public static void main(String[] args) {
        int countryPhoneCode = 38;
        int phoneNumber = 71112233;
        String strCountryPhoneCode = String.valueOf(countryPhoneCode);
        String strPhoneNumber = String.valueOf(phoneNumber);

        while (strPhoneNumber.length() < 10) {
            strPhoneNumber = "0" + strPhoneNumber;
        }
        String strCityCode = strPhoneNumber.substring(0, 3);
        String strPhoneNumberPart1 = strPhoneNumber.substring(3, 6);
        String strPhoneNumberPart2 = strPhoneNumber.substring(6, 8);
        String strPhoneNumberPart3 = strPhoneNumber.substring(8);
        System.out.printf("+%s(%s)%s-%s-%s", strCountryPhoneCode, strCityCode, strPhoneNumberPart1,
                strPhoneNumberPart2, strPhoneNumberPart3);
    }
}
