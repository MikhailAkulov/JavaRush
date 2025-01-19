package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность

Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.

В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines,
то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main.
Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

//    public static String firstFileName;
//    public static String secondFileName;

//        C:\Users\Akulo\Desktop\SourceDirectory\testFile1.txt
//        C:\Users\Akulo\Desktop\SourceDirectory\pushkin.txt

    public static void main(String[] args) {
        // 1 вариант
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
//            firstFileName = reader.readLine();
//            secondFileName = reader.readLine();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        String currentStr1;
//        try (BufferedReader buffReader = new BufferedReader(new FileReader(firstFileName))){
//            while ((currentStr1 = buffReader.readLine()) != null) {
//                allLines.add(currentStr1);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        String currentStr2;
//        try (BufferedReader buffReader = new BufferedReader(new FileReader(secondFileName))){
//            while ((currentStr2 = buffReader.readLine()) != null) {
//                forRemoveLines.add(currentStr2);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            new Solution().joinData();
//        } catch (CorruptedDataException e) {
//            e.printStackTrace();
//        }

        // 2 вариант
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = null;
        String fileName2 = null;
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            reader.close();
            BufferedReader fReader1 = new BufferedReader(new FileReader(fileName1));
            String input;
            while ((input = fReader1.readLine()) != null)
                allLines.add(input);
            fReader1.close();
            BufferedReader fReader2 = new BufferedReader(new FileReader(fileName2));
            while ((input = fReader2.readLine()) != null)
                forRemoveLines.add(input);
            fReader2.close();
            new Solution().joinData();
        } catch (Exception ignore) {
        }
    }

    public void joinData() throws CorruptedDataException {
        // 1 вариант
//        if (allLines.containsAll(forRemoveLines)) {
//            for (String str : forRemoveLines) {
//                allLines.remove(str);
//            }
//        } else {
//            allLines.clear();
//            throw new CorruptedDataException();
//        }

        // 2 вариант
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
