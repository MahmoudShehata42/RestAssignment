package org.example.restassignment.models.DTOs.RequestDTOs;

public class StudentSignUpRequest {
      final private String name;
      final private int age;
      final private String password;
      final private int score;
    public StudentSignUpRequest(String name, int age, String password, int score) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

 }
