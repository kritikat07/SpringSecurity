package com.kritika.SpringSecurity.model;

public class student {
    private int id;
    private String names;
    private int marks;

    public student(int id, String names, int marks) {
        this.id = id;
        this.names = names;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", marks=" + marks +
                '}';
    }
}
