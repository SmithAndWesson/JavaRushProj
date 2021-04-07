package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        while(true){
            try {
                 i = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                for (int x : list
                     ) {
                    System.out.println(x);
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(i);

        }
    }
}
