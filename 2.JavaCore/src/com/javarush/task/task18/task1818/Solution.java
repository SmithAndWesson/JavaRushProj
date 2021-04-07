package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileInputStream inputStream1 = new FileInputStream(reader.readLine());

        while (inputStream.available() > 0){
            outputStream.write(inputStream.read());
        }
        while (inputStream1.available() > 0){
            outputStream.write(inputStream1.read());
        }

        outputStream.close();
        inputStream.close();
        inputStream1.close();
    }
}
