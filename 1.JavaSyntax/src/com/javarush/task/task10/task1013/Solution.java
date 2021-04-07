package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int i;
        private short a;
        private long s;
        private double d;
        private float f;
        private char g;

        public Human(int i, long s) {
            this.i = i;
            this.s = s;
        }

        public Human(int i, char g) {
            this.i = i;
            this.g = g;
        }

        public Human(int i, float f) {
            this.i = i;
            this.f = f;
        }

        public Human(int i, double d) {
            this.i = i;
            this.d = d;
        }

        public Human(int i, short a, long s, double d, float f, char g) {
            this.i = i;
            this.a = a;
            this.s = s;
            this.d = d;
            this.f = f;
            this.g = g;
        }

        public Human(int i, short a, long s, double d, float f) {
            this.i = i;
            this.a = a;
            this.s = s;
            this.d = d;
            this.f = f;
        }

        public Human(int i, short a, long s, double d) {
            this.i = i;
            this.a = a;
            this.s = s;
            this.d = d;
        }

        public Human(int i, short a, long s) {
            this.i = i;
            this.a = a;
            this.s = s;
        }

        public Human(int i, short a) {
            this.i = i;
            this.a = a;
        }

        public Human(int i) {
            this.i = i;
        }
    }
}
