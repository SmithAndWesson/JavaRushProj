package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        InputStream inStream = new FileInputStream(br.readLine());

        while (inStream.available() > 0){
            System.out.print((char)inStream.read());
        }
        br.close();
        inStream.close();

    }
}