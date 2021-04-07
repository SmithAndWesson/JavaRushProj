package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        bufferedReader.close();

        while (reader.ready()){
            String str = reader.readLine();
            String[] mas = str.split(" ");

            for(String s : mas) {
                if (s.matches("\\d+")) writer.write(s + " ");
            }
        }

        reader.close();
        writer.close();
    }
}
