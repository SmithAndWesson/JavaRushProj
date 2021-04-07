package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {

        if(args.length < 3) return;

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");

        accessFile.seek(number > (int)accessFile.length() ? (int)accessFile.length() : number);
        accessFile.write(text.getBytes());
        accessFile.close();
    }
}
