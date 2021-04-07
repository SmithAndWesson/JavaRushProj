package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x1 = Integer.parseInt(reader.readLine());
        int x2 = Integer.parseInt(reader.readLine());
        if (x1 <= 0 || x2 <= 0) throw new Exception();

        System.out.println(nod(x1, x2));
    }

    public static int nod(int x1, int x2) {

        int min = 0;
        int n = 1;

        if (x1 < x2) min = x1;
        else min = x2;

        for (int i = min; i > n; i--) {
            if (x1 % i == 0 && x2 % i == 0) {
                n = i;
                break;
            }
        }

        return n;
    }
}