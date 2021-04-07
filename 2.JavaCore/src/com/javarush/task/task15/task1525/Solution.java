package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lines = fileReader.lines().collect(Collectors.toList());
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)  {


        System.out.println(lines);
    }
}
