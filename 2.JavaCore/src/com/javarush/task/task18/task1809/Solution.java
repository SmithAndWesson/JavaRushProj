package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(br.readLine());
        FileOutputStream outputStream = new FileOutputStream(br.readLine());
        ArrayList<Byte> list = new ArrayList<>();
        byte[] buffer = new byte[inputStream.available()];
        if(inputStream.available() > 0){
            int count = inputStream.read(buffer);
        }

        for(int i = buffer.length - 1 ; i >= 0; i--){
            outputStream.write(buffer[i]);
        }

        inputStream.close();
        outputStream.close();
    }
}
