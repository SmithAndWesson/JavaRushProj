package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> files = new TreeSet<>();
        String s;
        while(!(s = reader.readLine()).equals("end")){
            files.add(s);
        }
        String firstF = files.first();
        FileOutputStream fileOutputStream = new FileOutputStream(firstF.substring(0, firstF.lastIndexOf(".")), true);

        for (String fileName : files){

            FileInputStream stream = new FileInputStream(fileName);

            while (stream.available() > 0){
                byte[] buff = new byte[stream.available()];
                stream.read(buff);
                fileOutputStream.write(buff);
            }
            stream.close();
        }

        reader.close();
        fileOutputStream.close();

    }
}
