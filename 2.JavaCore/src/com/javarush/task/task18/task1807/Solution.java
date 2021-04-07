package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(br.readLine());
        int count = 0;

        while(inputStream.available() > 0){
            if(String.valueOf(Character.toChars(inputStream.read())).equals(",")) count++;
        }
        System.out.println(count);

        inputStream.close();
    }
}
