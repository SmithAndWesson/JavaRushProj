package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = false;
        System.out.println("Got: " + value);
        try {return value;
        }
        finally {
            notifyAll();
        }
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        isValuePresent = true;
        this.notifyAll();
        System.out.println("Put: " + value);
    }
}
