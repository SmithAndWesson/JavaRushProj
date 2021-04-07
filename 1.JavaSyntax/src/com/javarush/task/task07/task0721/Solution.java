package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        int maximum = 0;
        int minimum = 0;
        int[] mas = getInts();
        //напишите тут ваш код
        maximum = mas[0];
        minimum = mas[0];
        for(int i =0; i < mas.length; i++){
            int ch = mas[i];

            if(maximum < ch) maximum = ch;
            else if(minimum > ch)minimum = ch;
        }

        System.out.print(maximum + " " + minimum);
    }

    //напишите тут ваш код
    public static  int[] getInts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mas = new int[20];
        //напишите тут ваш код

        for(int i =0; i < 20; i++){
            mas[i] = Integer.parseInt(reader.readLine());

        }
        return mas;
    }
}
