package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(br.readLine()));
            BufferedReader reader2 = new BufferedReader(new FileReader(br.readLine()));

            String s1 = reader1.readLine();
            String s2 = reader2.readLine();

            while (s1 != null){
                allLines.add(s1);
                s1 = reader1.readLine();
            }

            while (s2 != null){
                forRemoveLines.add(s2);
                s2 = reader2.readLine();
            }
            (new Solution()).joinData();

        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
