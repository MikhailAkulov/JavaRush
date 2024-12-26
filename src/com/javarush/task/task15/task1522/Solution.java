package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton

нужно:
1. Найти пример паттерна Singleton с ленивой реализацией (lazy initialization).
2. По образу и подобию в отдельных файлах создать в отдельных файлах три класса синглтона — Sun, Moon, Earth.
3. Реализовать интерфейс Planet в классах Sun, Moon, Earth.
4. В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet().
5. Реализовать функционал метода readKeyFromConsoleAndInitPlanet():
- для этого считай с консоли один параметр типа String.
- если он равен одной из констант интерфейса Planet, создай соответствующий объект и присвой его Planet thePlanet, иначе — обнули Planet thePlanet.
*/

public class Solution {
    public static void main(String[] args) {}

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        reader.close();

        if (key.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        } else if (key.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        } else if (key.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        } else {
            thePlanet = null;
        }
    }
}
