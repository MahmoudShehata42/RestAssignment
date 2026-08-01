package org.example.restassignment.models.Entities;

import java.util.Objects;

public class Student {
    final int id;
    private String name;
    private int age;
    private int score;
    private String password;
  public Student(int id, String name, int age, int score , String password)
  {
      this.id = id;
      this.name = name;
      this.age = age;
      this.score = score;
      this.password=password;
  }
  public int getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public int getAge() {
      return age;
  }
  public int getScore() {
      return score;
  }
  public String getPassword() {
      return password;
  }
  public void setName(String name) {
      this.name = name;

  }
  public void setAge(int age) {
      this.age = age;
  }
  public void setScore(int score) {
      this.score = score;
  }
  public void setPassword(String password) {
      this.password = password;
  }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && score == student.score && Objects.equals(name, student.name) && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, score, password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", password='" + password + '\'' +
                '}';
    }
}
