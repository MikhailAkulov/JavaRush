package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution

Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));

//        try {
//            File fileName = new File("C:\\Users\\Akulo\\Desktop\\SourceDirectory\\testFile2014.txt");
//            OutputStream outputStream = new FileOutputStream(fileName);
//            InputStream inputStream = new FileInputStream(fileName);
//
//            Solution savedObject = new Solution(5);
//            savedObject.save(outputStream);
//            outputStream.flush();
//
//            Solution loadedObject = new Solution();
//            loadedObject.load(inputStream);
//            inputStream.close();
//
//            System.out.println(savedObject.equals(loadedObject));
//
//        } catch (FileNotFoundException e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with my file");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
//        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public Solution() {
    }

    @Override
    public String toString() {
        return this.string;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Solution solution = (Solution) o;
//        if (temperature != 0 ? temperature != solution.temperature : solution.temperature != 0) return false;
//        return temperature == solution.temperature;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = temperature != 0 ? (int) (temperature * 3.14) : 0;
//        result = 31 * result + 128;
//        return result;
//    }
//
//    public void save(OutputStream outputStream) throws Exception {
//        PrintWriter writer = new PrintWriter(outputStream);
//        writer.println(this.temperature);
//        writer.close();
//    }
//
//    public void load(InputStream inputStream) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//        this.temperature = Integer.parseInt(reader.readLine());
//        reader.close();
//    }
}
