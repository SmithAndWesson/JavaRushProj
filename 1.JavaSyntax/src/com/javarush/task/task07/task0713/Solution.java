package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> listMain = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i =0; i < 20; i++){
            listMain.add(Integer.parseInt(br.readLine()));
        }

        for (int a: listMain
             ) {
            if(a % 3 ==0) list1.add(a);
            if(a % 2 ==0) list2.add(a);
            if( a % 2 != 0 && a % 3 != 0) list3.add(a);
        }

        printList(list1);
        printList(list2);
        printList(list3);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int a : list
             ) {
            System.out.println(a);
        }
    }
}
