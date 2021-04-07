package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String text = "Я не хочу изучать Java, я хочу большую зарплату";
        String[] arr = text.split("");
        String viv = "";
        for(int i = 0; i < 40; i++){
            for(int j = i; j < arr.length; j++){
                viv += arr[j];
            }
            System.out.println(viv);
            viv = "";
        }
        //напишите тут ваш код
    }

}

