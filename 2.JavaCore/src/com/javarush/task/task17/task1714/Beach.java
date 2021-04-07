package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int i = 0;
        if(this.getName().length() > o.getName().length()) i++;
        else if(this.getName().length() < o.getName().length()) i--;

        if(this.getDistance() < o.getDistance()) i++;
        else if(this.getDistance() > o.getDistance())i--;

        if(this.getQuality() > o.getQuality()) i++;
        else if(this.getQuality() < o.getQuality()) i--;

        return i;
    }
}
