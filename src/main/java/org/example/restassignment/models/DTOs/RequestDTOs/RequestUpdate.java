package org.example.restassignment.models.DTOs.RequestDTOs;

public class RequestUpdate {
    public final int id;
    public  String name;
    public  String password;
    public  int age;
    public  int score;

    public RequestUpdate(int id, String name, String password, int age, int score) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.score = score;

    }

}
