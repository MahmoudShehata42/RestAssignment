package org.example.restassignment.services;

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
         return null;
     }
     FoundStudent foundStudent=new FoundStudent(
             student.getId(),student.getName(),student.getAge(),student.getScore()
     );
     return foundStudent;
    }

    public void  deleteStudent(int id) {

            studentRepository.delete(id);

    }
    public  void  updateStudent(@NonNull RequestUpdate  requestUpdate) {

        Student ToBeUpdatedStudent = studentRepository.getByID(requestUpdate.id);
        ToBeUpdatedStudent.setName(requestUpdate.name);
        ToBeUpdatedStudent.setAge(requestUpdate.age);
        ToBeUpdatedStudent.setScore(requestUpdate.score);

        studentRepository.update(ToBeUpdatedStudent);
    }

 }
