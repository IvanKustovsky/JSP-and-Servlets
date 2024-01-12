package com.example.servletdemo.utils;

import com.example.servletdemo.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

    public static List<Student> getStudents() {

        // create an empty list
        List<Student> students = new ArrayList<>();

        // adding sample data
        students.add(new Student("Ivan","Kustovsky","vanyakust123email@gmail.com"));
        students.add(new Student("Nikita","Koval","kovalnitita653@gmail.com"));
        students.add(new Student("Olesya","Grazdan","olesyaemail8656@gmail.com"));
        students.add(new Student("Oleksii","Shevchenko","shevaoleksii9821@gmail.com"));
        students.add(new Student("Marina","Lisenko","lisenkomarina@gmail.com"));

        // return the list
        return students;
    }
}
