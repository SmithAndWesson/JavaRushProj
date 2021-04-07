package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s :
                students) {
            if(s.getAverageGrade() == averageGrade) return s;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = students.get(0).getAverageGrade();
        Student student = students.get(0);
        for (Student s : students){
            if(max < s.getAverageGrade()) {
                max = s.getAverageGrade();
                student = s;
            }
        }

        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        double min = students.get(0).getAverageGrade();
        Student student = students.get(0);
        for (Student s : students){
            if(min > s.getAverageGrade()) {
                min = s.getAverageGrade();
                student = s;
            }
        }

        return student;
    }

    public void expel(Student student){
        students.remove(student);
    }
}