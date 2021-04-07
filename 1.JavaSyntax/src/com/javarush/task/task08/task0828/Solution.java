package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        //напишите тут ваш код
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateFormat df = new SimpleDateFormat("MMMMM", Locale.ENGLISH);
        String month = br.readLine();
        Date d = df.parse(month);
        System.out.println(month + " is the " + (d.getMonth() + 1) + " month");*/

        HashMap<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February",2);
        map.put("March",3);
        map.put("April",4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July",7);
        map.put("August",8);
        map.put("September",9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        for (HashMap.Entry<String, Integer> pair : map.entrySet())
        {
            String key = pair.getKey();
            if (month.equals(key))
                System.out.println(month + " is the " + map.get(key) + " month");
        }
    }
}
