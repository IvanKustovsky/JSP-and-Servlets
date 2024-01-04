package com.example.tagdemo;

public class Student {

    private String firstName;
    private String lastName;
    private boolean vip;

    public Student(String firstName, String lastName, boolean vip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vip = vip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
