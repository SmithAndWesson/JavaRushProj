package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {

        if (inputArray == null || inputArray.length == 0) {
            return new Pair<Integer, Integer>(null, null);

        }else{
            int min = inputArray[0];
            int max = inputArray[0];
            for (int i: inputArray
                 ) {
                if(min > i) min = i;
                else if(max < i) max = i;
            }
            return new Pair<Integer, Integer>(min, max);
        }

        // напишите тут ваш код

    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
