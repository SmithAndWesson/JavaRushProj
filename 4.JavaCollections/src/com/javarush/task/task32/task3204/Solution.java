package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        Random random = new Random();

        for(int i = 0; i < 3; i++){
            arrayOutputStream.write(48 + random.nextInt(10));
            arrayOutputStream.write(65 + random.nextInt(26));
        }

        for(int j = 0; j < 2; j++){
            arrayOutputStream.write(97 + random.nextInt(26));
        }
        return arrayOutputStream;
    }
}
