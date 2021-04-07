package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
    private static int lineLength = 8 + 30 + 8 + 4;
    public static void main(String[] args) throws Exception {
        if (args.length < 2)
            return;
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();
        processParams(args, fileName);
    }

    public static boolean containsId(String s, int id) throws IOException {
        return (id == Integer.parseInt(s.substring(0, 8).trim()));
    }

    public static void processParams(String[] args, String fileName) throws IOException, FileNotFoundException {
        String updLine = "";
        int id = 0;
        switch (args[0]) {
            case "-u":
                id = Integer.parseInt(args[1]);
                String productName = args[2];
                double price = 0.0;
                int quantity = 0;
                int i;
                for (i = 3; i < lineLength + 2; i++) { //+ "-u".length
                    try {
                        price = Double.parseDouble(args[i]);
                        break;
                    } catch (NumberFormatException e) {
                        productName += " " +args[i];
                    }
                }
                try {
                    quantity = Integer.parseInt(args[++i]);}
                catch (NumberFormatException e) {
                    System.out.println("quantity: NumberFormatException " + e.getMessage());
                }
                updLine = String.format(Locale.ENGLISH, "%-8d%-30s%-8.2f%-4d", id, productName, price, quantity);
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                break;
        }

        BufferedReader r = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = r.readLine()) != null)
            if (containsId(s, id))
                switch (args[0]) {
                    case "-u":
                        sb.append("\r\n" + updLine);
                        break;
                    case "-d":
                        //eliminating appending of line
                        break;
                } else sb.append("\r\n" + s);


        BufferedWriter f = new BufferedWriter(new FileWriter(fileName));
        f.write(sb.toString().substring(2));
        f.close();
        r.close();
    }
}