package com.javarush.task.task17.task1714;

/* 
Comparable

Реализуй интерфейс Comparable<Beach> в классе Beach.
Пляжи(Beach) будут использоваться нитями, поэтому позаботься, чтобы все методы были синхронизированы.
Реализуй метод compareTo так, чтобы при сравнении двух пляжей он выдавал:
– положительное число, если первый пляж лучше;
– отрицательное число, если второй пляж лучше;
– ноль, если пляжи одинаковые.
Сравни каждый критерий по отдельности, чтобы победителем был пляж с лучшими показателями по большинству критериев.
Учти при сравнении, чем меньше расстояние к пляжу (distance), тем пляж лучше.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach first = new Beach("first", 5, 4);
        Beach second = new Beach("second", 6, 5);
        System.out.println(first.compareTo(second));
    }

    @Override
    public synchronized int compareTo(Beach o) {
//         1 вариант
//        if (this.quality == o.quality) {
//            if (this.distance < o.distance) {
//                return 1;
//            } else if (this.distance >  o.distance){
//                return -1;
//            }
//        } else if (this.distance == o.distance){
//            if (this.quality > o.quality) {
//                return 1;
//            } else if (this.quality < o.quality){
//                return -1;
//            }
//        }
//        return 0;

        // 2 вариант
        int current = 0;
        int other = 0;
        float deltaDistance = distance - o.getDistance();
        if (deltaDistance > 0) {
            other++;
        } else if (deltaDistance< 0) {
            current++;
        }
        int deltaQuality = quality - o.getQuality();
        if (deltaQuality > 0) {
            current++;
        } else if (deltaQuality < 0) {
            other++;
        }
        return current - other;
    }
}
