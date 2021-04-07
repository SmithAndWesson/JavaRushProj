package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        if(args.length < 3) return;

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
        byte[] arr = new byte[text.length()];
        accessFile.seek(number);
        accessFile.read(arr, 0, text.length());
        String readedText = new String(arr);
        accessFile.seek(accessFile.length());
        accessFile.write((readedText.equals(text) ? "true" : "false").getBytes());
        accessFile.close();
    }
}
