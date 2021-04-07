package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(args[0]));
        BufferedReader reader = new BufferedReader(inputStreamReader);
        int count = 0;
        while (reader.ready()){
            if(String.valueOf((char)reader.read()).toLowerCase().matches(".*[A-Za-z].*")) count++;
        }

        reader.close();
        System.out.println(count);

    }
}
