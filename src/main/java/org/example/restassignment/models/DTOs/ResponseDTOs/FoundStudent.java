package org.example.restassignment.models.DTOs.ResponseDTOs;

public class FoundStudent {
  public final int id;
  public final String name;
  public final int age;
  public final int score;

  public FoundStudent(int id, String name, int age, int score) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.score = score;
  }



}
