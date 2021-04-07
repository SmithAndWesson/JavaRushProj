package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

/*
Нашествие исключений
*/
public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {

            exceptions.add(e);
            exceptions.add(new ArithmeticException());
            exceptions.add(new NumberFormatException());
            exceptions.add(new ArrayIndexOutOfBoundsException());
            exceptions.add(new ArrayStoreException());
            exceptions.add(new ClassCastException());
            exceptions.add(new NegativeArraySizeException());
            exceptions.add(new NullPointerException());
            exceptions.add(new StringIndexOutOfBoundsException());
            exceptions.add(new InterruptedException());

        }

    }


}