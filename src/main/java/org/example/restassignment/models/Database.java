package org.example.restassignment.models;

import org.example.restassignment.models.Entities.Student;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static  int IdIncreamental=6;

    public static List<Student> students = new ArrayList<>();


    static {
        students.add(new Student(1, "Ahmed", 20, 95, "1234"));
        students.add(new Student(2, "Mohamed", 21, 88, "abcd"));
        students.add(new Student(3, "Sara", 19, 72, "pass"));
        students.add(new Student(4, "Mona", 22, 48, "mona"));
        students.add(new Student(5, "Ali", 18, 35, "ali"));
    }
}
