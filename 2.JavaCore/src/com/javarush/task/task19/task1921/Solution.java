package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if (args.length != 1) return;
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        String str;
        while ((str = fileIn.readLine()) != null) {
            String[] bstr = str.replace("\n", "").split(" ");

            int year = Integer.parseInt(bstr[bstr.length - 1]);
            int month = Integer.parseInt(bstr[bstr.length - 2]);
            int day = Integer.parseInt(bstr[bstr.length - 3]);
            Date birthday = new GregorianCalendar(year, month - 1, day).getTime();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bstr.length - 3; i++) {
                sb.append(bstr[i]);
                sb.append(" ");
            }
            PEOPLE.add(new Person(sb.toString().trim(), birthday));
        }
        fileIn.close();
    }
}
