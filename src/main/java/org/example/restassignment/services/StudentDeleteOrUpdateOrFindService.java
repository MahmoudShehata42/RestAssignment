package org.example.restassignment.services;

import org.example.restassignment.errors.StudentNotFound;
import org.example.restassignment.models.DTOs.RequestDTOs.RequestUpdate;
import org.example.restassignment.models.DTOs.ResponseDTOs.FoundStudent;
import org.example.restassignment.models.Entities.Student;
import org.example.restassignment.repositories.StudentRepository;
import org.jspecify.annotations.NonNull;

public class StudentDeleteOrUpdateOrFindService {
    StudentRepository studentRepository = new StudentRepository();
    public FoundStudent  findStudnet(int id) {
     Student student=   studentRepository.getByID(id);
     if(student==null){
               throw new StudentNotFound("Student not found");

     }
     FoundStudent foundStudent=new FoundStudent(
             student.getId(),student.getName(),student.getAge(),student.getScore()
     );
     return foundStudent;
    }

    public void  deleteStudent(int id) {

        Student ToBeUpdateleted = studentRepository.getByID(id);

        if( ToBeUpdateleted==null){
            throw new StudentNotFound("Student not found");
        }
            studentRepository.delete(id);

    }
    public  void  updateStudent(@NonNull RequestUpdate  requestUpdate) {

        Student ToBeUpdatedStudent = studentRepository.getByID(requestUpdate.id);
        if(ToBeUpdatedStudent==null){
            throw new StudentNotFound("Student not found");
        }
        ToBeUpdatedStudent.setName(requestUpdate.name);
        ToBeUpdatedStudent.setAge(requestUpdate.age);
        ToBeUpdatedStudent.setScore(requestUpdate.score);

        studentRepository.update(ToBeUpdatedStudent);
    }

 }
