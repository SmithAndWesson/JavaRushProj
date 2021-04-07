package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String[] mas = string.split(" ");
        String[] mas1;
        for (String s : mas
             ) {
            mas1 = s.split("");
            s = mas1[0].toUpperCase();
            for(int i = 1; i < mas1.length; i++){
                s += mas1[i];
            }
            System.out.print(s + " ");
        }
        //напишите тут ваш код
    }
}
