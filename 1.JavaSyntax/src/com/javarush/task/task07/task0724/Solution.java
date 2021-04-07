package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {


    public static void main(String[] args) {
        // напишите тут ваш код
        Human m1 = new Human("1", true, 1);
        Human m2 = new Human("1", true, 1);
        Human m3 = new Human("1", true, 1);
        Human m4 = new Human("1", true, 1);

        Human mm1 = new Human("1", true, 1, m1, m2);
        Human mm2 = new Human("1", true, 1, m1, m2);
        Human mm3 = new Human("1", true, 1, m1, m2);
        Human mm4 = new Human("1", true, 1, m1, m2);
        Human mm5 = new Human("1", true, 1, m1, m2);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);
        System.out.println(mm1);
        System.out.println(mm2);
        System.out.println(mm3);
        System.out.println(mm4);
        System.out.println(mm5);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}