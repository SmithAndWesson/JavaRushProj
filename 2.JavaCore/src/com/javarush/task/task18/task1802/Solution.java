package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(br.readLine());
        int bigger = fileInputStream.read();
        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();
            if(i < bigger) bigger = i;
        }

        br.close();
        fileInputStream.close();
        System.out.println(bigger);
    }
}
