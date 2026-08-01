package org.example.restassignment.services;

import org.example.restassignment.models.Entities.Student;
import org.example.restassignment.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class FilterWhoPassAndTheFirstOneRanked {
    StudentRepository studentRepository = new StudentRepository();

    public String getTheNumberOne(){

      Student NumberOneStudent =studentRepository.GetTheFirstOneRanked();
      return NumberOneStudent.getName();
    }
    public  List<String> getWhoPass(){
       List< Student> WhoPassStudent =studentRepository.GetWhoPass();
    List<String> WhoPassStudentName= new ArrayList<>();
    for (Student student : WhoPassStudent){
        WhoPassStudentName.add(student.getName());
    }
    return WhoPassStudentName;
    }



}
