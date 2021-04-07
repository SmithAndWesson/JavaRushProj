package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<FileInputStream> list = new ArrayList<>();
        while(true){
            String name = null;
            try {
                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileInputStream stream = new FileInputStream(name);
                list.add(stream);
            } catch ( FileNotFoundException e) {
                System.out.println(name);
                try {
                    reader.close();
                    for(FileInputStream stream : list){
                        stream.close();
                    }
                } catch (IOException ioException) {
                }
                break;


            } catch (IOException e) {
                break;
            }
        }
    }
}
