package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("FEBRUARY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Date start = new Date (date);
        start.setMonth(0);
        start.setDate(0);
        Date today = new Date (date);
        long msDistance = today.getTime()-start.getTime();
        long msDay = 24*60*60*1000;
        int dayCount = (int) (msDistance/msDay);

        return dayCount % 2 != 0;

    }
}
