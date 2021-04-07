package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset(){
        //add your code here - добавьте код тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = br.readLine();
            if(s.equals("helicopter")){
                result = new Helicopter();
            }else if(s.equals("plane")){
                result = new Plane(Integer.parseInt(br.readLine()));

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
