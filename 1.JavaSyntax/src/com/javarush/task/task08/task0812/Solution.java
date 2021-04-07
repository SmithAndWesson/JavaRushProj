package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> listDlin = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 10; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        int j = list.get(0), dlina = 0, maxDlina = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()
             ) {
            int x = iterator.next();
            if(x == j) dlina++;

            if(x != j || !iterator.hasNext()) {
                listDlin.add(dlina);
                dlina =1;
                j = x;
            }
        }

        for (int s : listDlin
             ) {
            if(s > maxDlina) maxDlina = s;
        }
        System.out.println(maxDlina);
    }
}
