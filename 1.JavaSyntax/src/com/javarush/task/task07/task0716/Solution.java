package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        //strings.add("роза");
        //strings.add("лоза");
        //strings.add("лира");
        strings.add("роза");
        strings.add("мера");
        strings.add("лоза");
        strings.add("лира");
        strings.add("вода");
        strings.add("упор");

        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        for (int i =0; i < strings.size() ;) {
            String s = strings.get(i);
            if(s.contains("р") && s.contains("л")) {
                i++;
                continue;

            }
            if(s.contains("р")) {
                strings.remove(i);
                continue;
            }
            if(s.contains("л")) {
                strings.add(i,s);
                i +=2;


            }
            else i++;

        }
        return strings;
    }
}