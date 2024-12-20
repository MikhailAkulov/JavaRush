package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;

        // 1 вариант
//        String key = null;
//        boolean flag = true;
//        while (flag) {
//            key = reader.readLine();
//            if (key.equals("user")) {
//                person = new Person.User();
//                doWork(person);
//            } else if (key.equals("loser")) {
//                person = new Person.Loser();
//                doWork(person);
//            } else if (key.equals("coder")) {
//                person = new Person.Coder();
//                doWork(person);
//            } else if (key.equals("proger")) {
//                person = new Person.Proger();
//                doWork(person);
//            } else
//                flag = false;
//        }

        // 2 вариант
        //read values from keyboard here
        String key;
        while (true) {
            key = reader.readLine();
            boolean u = key.equals("user") || key.equals("loser") || key.equals("coder") || key.equals("proger");
            if (!u) break;

            switch (key) {
                case "user":
                    person = new Person.User();
                    break;
                case "loser":
                    person = new Person.Loser();
                    break;
                case "coder":
                    person = new Person.Coder();
                    break;
                case "proger":
                    person = new Person.Proger();
                    break;
            }
            doWork(person);
        }
    }

    public static void doWork(Person person) {
        // 1 вариант
//        if (person instanceof Person.User) {
//            ((Person.User) person).live();
//        } else if (person instanceof Person.Loser) {
//            ((Person.Loser) person).doNothing();
//        } else if (person instanceof Person.Coder) {
//            ((Person.Coder) person).writeCode();
//        } else if (person instanceof Person.Proger) {
//            ((Person.Proger) person).enjoy();
//        }

        // 2 вариант
        if (person instanceof Person.User) {
            Person.User user = (Person.User) person;
            user.live();
        } else if (person instanceof Person.Loser) {
            Person.Loser loser = (Person.Loser) person;
            loser.doNothing();
        } else if (person instanceof Person.Coder) {
            Person.Coder coder = (Person.Coder) person;
            coder.writeCode();
        } else if (person instanceof Person.Proger) {
            Person.Proger proger = (Person.Proger) person;
            proger.enjoy();
        }
    }
}
