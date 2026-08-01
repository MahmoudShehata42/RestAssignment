package org.example.restassignment.services;

import org.example.restassignment.errors.StudentNotFound;
import org.example.restassignment.models.DTOs.RequestDTOs.RequestLoginDTO;
import org.example.restassignment.models.DTOs.RequestDTOs.StudentSignUpRequest;
import org.example.restassignment.models.Entities.Student;
import org.example.restassignment.repositories.StudentRepository;
import org.jspecify.annotations.NonNull;

import static org.example.restassignment.models.Database.IdIncreamental;

public class StudentServiceLogInSignUp {
    StudentRepository  studentRepository=new StudentRepository();

    public int signup(@NonNull StudentSignUpRequest student){

        Student THEAddedStudent =new Student(IdIncreamental,student.getName(),student.getAge(),student.getScore(),student.getPassword());
       studentRepository.add(THEAddedStudent);
       IdIncreamental++;
       return THEAddedStudent.getId();

    }
    public boolean login(@NonNull RequestLoginDTO LogedINstudent) throws Exception{
       Student LoggerStudent= studentRepository.getByID(LogedINstudent.getUserId());
       if(LoggerStudent==null ){
           throw  new StudentNotFound("Student not found");
       }
       if (!(LoggerStudent.getPassword().equals( LogedINstudent.getPassword()))){


           return  false;
       }

       return true;
    }
    public void RegisterAlistOfStudents(@NonNull StudentSignUpRequest[] studentSignUpRequests)
     {
        for (StudentSignUpRequest studentSignUpRequest : studentSignUpRequests) {
            signup(studentSignUpRequest);
        }

    }



}
