package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(){
            @Override
            public void run() {
                while(true){
                    int i = 1;
                }
            }
        });

        threads.add(new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        });

        threads.add(new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Ура");
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }
            }
        });

        threads.add(new Warning());

        threads.add(new Thread(){
            @Override
            public void run() {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int summ = 0;
                while (isAlive()) {
                    try {
                        String s = br.readLine();
                        if(s.equals("N")) System.out.println(summ);

                        summ += Integer.parseInt(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public static void main(String[] args) {
    }

    public static class Warning extends Thread implements Message{
        @Override
        public void run() {
            while (!this.isInterrupted()){
                int i = 1;
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();

        }
    }
}