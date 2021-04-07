package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        String str = "";
        int i = 0;
        while (fileReader.ready()){
            str += String.valueOf((char)fileReader.read()).toLowerCase();
        }
        reader.close();
        fileReader.close();

//        str.replaceAll("\\p{Punct}", " ");
//        str = str.replaceAll("\n", " ");
        str.toLowerCase();
        String[] words = str.split(" ");

        for(String stroka : str.split("[^a-zA-Z0-9]")){
            if(stroka.equals("world")) i++;
        }

        System.out.println(i);
    }
}
