package com.javarush.task.task19.extraExamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * BufferedReader — очень гибкий механизм, и позволяет работать не только с клавиатурой.
 * Считывать данные можно, например, напрямую из Сети, просто передав ридеру нужный URL:
 */
public class URLReaderExample {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("https://www.oracle.com/index.html");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}
