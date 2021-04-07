package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Child1", true, 7, new ArrayList<Human>());
        Human child2 = new Human("Child2", false, 6, new ArrayList<Human>());
        Human child3 = new Human("Child3", true, 10, new ArrayList<Human>());
        ArrayList<Human> child = new ArrayList<>();
        child.add(child1);
        child.add(child2);
        child.add(child3);
        Human mother = new Human("Mother", false, 35, child);
        Human father = new Human("Father", true, 40, child);
        ArrayList<Human> father1 = new ArrayList<>();
        father1.add(father);
        ArrayList<Human> mother1 = new ArrayList<>();
        mother1.add(mother);
        Human grandpa1 = new Human("Grandpa1", true, 90, father1);
        Human grandma1 = new Human("Grandma1", false, 88, father1);
        Human grandpa2 = new Human("Grandpa2", true, 95, mother1);
        Human grandma2 = new Human("Grandma2", false, 90, mother1);

        System.out.println(grandpa1);
        System.out.println(grandpa2);
        System.out.println(grandma1);
        System.out.println(grandma2);

        System.out.println(father);
        System.out.println(mother);

        for (Human human : child) {
            System.out.println(human);
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
