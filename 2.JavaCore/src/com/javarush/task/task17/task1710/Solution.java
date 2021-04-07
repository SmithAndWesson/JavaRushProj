package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        if (args.length < 2) {
            return;
        }

        int length = args.length;
        String name = new String();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args[0].contentEquals("-c")) {
            for (int i = 1; i < length - 2; i++)
                name = name + args[i];
            if (args[length - 2].contentEquals("м"))
                allPeople.add(Person.createMale(name, dateFormat.parse(args[length - 1])));
            else if (args[length - 2].contentEquals("ж"))
                allPeople.add(Person.createFemale(name, dateFormat.parse(args[length - 1])));
            System.out.println(allPeople.size()-1);
        }
        else if (args[0].contentEquals("-u"))
        {
            for (int i = 2; i < length - 2; i++)
                name = name + args[i];
            if (args[length - 2].contentEquals("м"))
                allPeople.set(Integer.parseInt(args[1]), Person.createMale(name, dateFormat.parse(args[length - 1])));
            else if (args[length - 2].contentEquals("ж"))
                allPeople.set(Integer.parseInt(args[1]), Person.createFemale(name, dateFormat.parse(args[length - 1])));
        }
        else if (args[0].contentEquals("-d"))
        {
            Person person = allPeople.get((Integer.parseInt(args[1])));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            allPeople.set((Integer.parseInt(args[1])),person);
        }
        else if (args[0].contentEquals("-i"))
        {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String sex = person.getSex().equals("MALE") ? "ж" : "м";
            System.out.print(allPeople.get(Integer.parseInt(args[1])).getName() + " ");
            System.out.print(sex + " ");
            System.out.println(dateFormat1.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
        }

    }
}
