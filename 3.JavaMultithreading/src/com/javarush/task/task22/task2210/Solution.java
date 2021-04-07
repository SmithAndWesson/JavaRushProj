package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

        String[] a = getTokens("level22.lesson13.task01", ".");
        for (String s: a
             ) {
            System.out.println(s);

        }


    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer s = new StringTokenizer(query, delimiter);
        List<String> mas = new ArrayList<String>();
        while (s.hasMoreElements()){
            mas.add(s.nextToken());
        }

        return mas.toArray(new String[0]);
    }
}
