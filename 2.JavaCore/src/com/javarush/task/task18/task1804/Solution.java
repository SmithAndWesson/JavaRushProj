package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    FileInputStream inputStream = new FileInputStream(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> fin = new ArrayList<>();
        int ncur = 0;
        int nmin = list.size() ;

        while (inputStream.available() > 0){
            list.add(inputStream.read());
        }

        Collections.sort(list);
        for(int i = 0; i < list.size() - 1; i ++){
            if(list.get(i) == list.get(i + 1)) ncur++;
            else{
                if(ncur < nmin){
                    fin.clear();
                    fin.add(list.get(i));
                    nmin = ncur;

                }

                else if(ncur == nmin && !fin.contains(list.get(i))) fin.add(list.get(i));

                ncur = 0;
            }
        }

        for(int x : fin){
            System.out.print(x + " ");
        }
        br.close();
        inputStream.close();
    }
}
