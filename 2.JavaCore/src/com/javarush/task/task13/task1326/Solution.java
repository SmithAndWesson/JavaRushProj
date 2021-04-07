package com.javarush.task.task13.task1326;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        //открываем входящий поток, читающий с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //поток, читающий из файла
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        //Коллекция
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Преобразуем в int и узнаем четный или нет
        while (reader.ready()) {
            int num = Integer.parseInt(reader.readLine());
            if (num % 2 == 0) {
                numbers.add(num);
            }
        }
        // Закрываем ридер
        reader.close();

        // Сортируем коллекцию
        Collections.sort(numbers);

        // вывод на экран
        for (int i : numbers) {
            System.out.println(i);
        }


    }
}
