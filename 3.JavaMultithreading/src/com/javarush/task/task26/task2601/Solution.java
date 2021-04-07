package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //Находим медиану
        //Сортируем массив из параметра
        int median;
        Arrays.sort(array);
        //Если массив с четным колличеством элементов
        if (array.length%2==0) median = (array[array.length/2] + array[array.length/2-1])/2;
            //И если с нечетным
        else median = array[array.length/2];

        //Сортируем по условию
        Arrays.sort(array,(x,y)->Integer.compare(Math.abs(median-x), Math.abs(median-y)));
        return array;


//        ВТОРОЙ ВАРИАНТ
//        Arrays.sort(array);
//        int len = array.length;
//        int mediana = len % 2 != 0 ? array[len / 2] : (int)((array[len / 2] + array[len / 2 - 1]) / 2);
//
//        Comparator<Integer> comp = new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
//            }
//        };
//
////        то же самое через лямбду
////        Comparator<Integer> comp = (o1, o2) -> Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
//
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
//        Collections.sort(list, comp);
//        Integer[] rez = list.toArray(new Integer[list.size()]);
//        return rez;

    }
}
