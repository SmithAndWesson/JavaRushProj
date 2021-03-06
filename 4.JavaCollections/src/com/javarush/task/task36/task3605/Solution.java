package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        TreeSet<Character> result = new TreeSet<>();

        new String(Files.readAllBytes(Paths.get(args[0])))
                .toLowerCase().chars()
                .mapToObj(c-> (char)c).filter(Character::isLetter)
                .forEach(result::add);
        result.stream().limit(5).forEach(System.out::print);

//        TreeSet<Character> letters = new TreeSet<>();
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
//            while (fileReader.ready()) {
//                String s = fileReader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]",""); //\s\p{Punct}
//                for (int i = 0; i < s.length(); i++)
//                    letters.add(s.charAt(i));
//            }
//        }
//
//        Iterator<Character> iterator = letters.iterator();
//        int n = letters.size() < 5 ? letters.size() : 5;
//
//        for (int i = 0; i < n; i++) {
//            System.out.print((iterator.next()));
//        }
    }
}
