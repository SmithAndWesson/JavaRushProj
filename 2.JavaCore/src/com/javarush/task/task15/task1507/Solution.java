package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int m, int n, int n1, int n2) {

    }

    public static void printMatrix(int m, int n, int n1,int n2, int n3) {

    }

    public static void printMatrix(int m, int n, int n1,int n2, int n3, int n4) {

    }
    public static void printMatrix(int m, int n, int n1,int n2, int n3, int n4, int n5) {

    }
    public static void printMatrix(int m, int n, int n1,int n2, int n3, int n4, int n5, int n6) {

    }
    public static void printMatrix(int m, int n, int n1,int n2, int n3, int n4, int n5, int n6, int n7) {

    }
    public static void printMatrix(int m, int n, int n1,int n2, int n3, int n4, int n5, int n6, int n7, int n8) {

    }
    public static void printMatrix(int m, int n, int n1,int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {

    }
}
