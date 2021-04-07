package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(path);

        Map<Integer, Integer> listOfChars = new HashMap<>();

        // список для вывода уникальных значени самых частовстречающихся
        List<Integer> listForOutput = new ArrayList<>();

        // под хранение считанного символа
        Integer tmpInt;
        // Максимальная частота
        Integer maxFreq = 0;

        while (fileInputStream.available() > 0) {
            // считали один символ из потокаa
            tmpInt = fileInputStream.read();
            // если считанный символ уже содержится в HashMap - увеличиваем счетчик на 1
            if (listOfChars.containsKey(tmpInt)) {
                // считываем старое значение и инкрементируем на 1
                Integer tmp = (Integer) listOfChars.get(tmpInt) + 1;

                // заносим обновленное значение количества повторов в HashMap в соответствии
                // с ключем - собственно, уникальным считанным из файла символом
                listOfChars.put(tmpInt, tmp);

                // находим минимальное значение частоты повторов в тексте
                if (tmp > maxFreq) {
                    maxFreq = tmp;
                }
            }
            // если считанный символ новый и уникальный - вносим его в HashMap
            // и проставляем первоначальное количество 1
            else {
                listOfChars.put(tmpInt, 1);
            }
        }
        bufferedReader.close();
        fileInputStream.close();

        // заночсим в отдельный список самые часто повторяющиеся символы
        for (Map.Entry<Integer, Integer> pair: listOfChars.entrySet()) {
            if (pair.getValue().equals(maxFreq)) {
                if (!listForOutput.contains(pair.getValue())) {
                    listForOutput.add(pair.getKey());
                }
            }
        }

        // вывод первого элемента
        System.out.print(listForOutput.get(0));

        // вывод оставшихся элементов
        if (listForOutput.size() > 2) {
            for (int i = 1; i < listForOutput.size(); i++) {
                System.out.print(" " + listForOutput.get(i));
            }
        }


    }
}
