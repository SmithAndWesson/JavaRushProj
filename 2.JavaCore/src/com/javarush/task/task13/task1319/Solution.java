package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(br.readLine()));

        while(true){
            String s = br.readLine();

            bw.write(s);
            bw.newLine();
            if(s.equals("exit")) break;


        }

        bw.close();
        br.close();
    }
}
