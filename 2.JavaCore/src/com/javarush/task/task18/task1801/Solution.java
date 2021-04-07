package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(br.readLine());

        int i = inputStream.read();
        while (inputStream.available() > 0){
            int a = inputStream.read();
            if(a > i) i = a;
        }
        inputStream.close();
        System.out.println(i);
    }
}
