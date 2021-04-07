package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat bdIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat bdOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try {
            switch (args[0]){
                case "-c" :
                    synchronized (allPeople){
                        Person person = null;
                        for (int i = 1; i < args.length; i++) {
                            if (args[i].equals("м")) {
                                person = Person.createMale(args[i - 1], bdIn.parse(args[i + 1]));
                                allPeople.add(person);
                                System.out.println(allPeople.indexOf(person));
                            } else if (args[i].equals("ж")) {
                                person = Person.createFemale(args[i - 1], bdIn.parse(args[i + 1]));
                                allPeople.add(person);
                                System.out.println(allPeople.indexOf(person));
                            }
                        }
                    }break;
                case "-u" :
                    synchronized (allPeople){
                        for (int i = 1; i < args.length; i += 4) {
                            allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                            if (args[i + 2].equals("м")) {
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                            } else if (args[i + 2].equals("ж")) {
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                            }
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(bdIn.parse(args[i + 3]));
                        }
                    }break;
                case "-d" :
                    synchronized (allPeople){
                        for (int i = 1; i < args.length; i++) {
                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        }
                    }break;
                case "-i" :
                    synchronized (allPeople){
                        for (int i = 1; i < args.length; i++) {
                            System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() +
                                    " " + (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE) ? "м" : "ж") +
                                    " " + bdOut.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));
                        }
                    }break;

            }

        }catch (ParseException e){
            System.out.println(e);
        }

        //start here - начни тут
    }
}