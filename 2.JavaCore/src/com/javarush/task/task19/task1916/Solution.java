package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
//        C:\Users\Andrey\Documents\111.txt
//        C:\Users\Andrey\Documents\222.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        ArrayList<String> f1 = new ArrayList<>();
        ArrayList<String> f2 = new ArrayList<>();

        while (readerFile1.ready()) {
            f1.add(readerFile1.readLine());
        }
        while (readerFile2.ready()) {
            f2.add(readerFile2.readLine());
        }

        while (f1.size()>0 && f2.size()>0) {    //isEmpty()

            if (f1.get(0).equals(f2.get(0))) {
                lines.add(new LineItem(Type.SAME, f1.get(0)));
                f1.remove(0);
                f2.remove(0);
            } else if (f1.get(0).equals(f2.get(1))) {
                lines.add(new LineItem(Type.ADDED, f2.get(0)));
                f2.remove(0);
            } else {
                lines.add(new LineItem(Type.REMOVED, f1.get(0)));
                f1.remove(0);
            }

        }
        if (f1.size() > 0) {    //isEmpty()
            lines.add(new LineItem(Type.REMOVED, f1.get(0)));
            f1.remove(0);
        }
        if (f2.size() > 0) {    //isEmpty()
            lines.add(new LineItem(Type.ADDED, f2.get(0)));
            f2.remove(0);
        }


        readerFile1.close();
        readerFile2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
