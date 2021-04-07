package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fName);


        byte[] a = new byte[inputStream.available()];
        inputStream.read(a);

        FileOutputStream outputStream = new FileOutputStream(fName);
        FileInputStream inputStream1 = new FileInputStream(reader.readLine());

        while (inputStream1.available() > 0){
            outputStream.write(inputStream1.read());
        }

        outputStream.write(a);

        outputStream.close();
        inputStream.close();
        inputStream1.close();

    }
}
