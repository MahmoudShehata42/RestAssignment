package org.example.restassignment.repositories;

import org.example.restassignment.models.Entities.Student;

import java.util.Comparator;
import java.util.List;
import static org.example.restassignment.models.Database.students;
public class StudentRepository implements IStudent{
    @Override
    public void add(Student entity) {
        students.add(entity);

    }

    @Override
    public void update(Student entity) {
        students.set(students.indexOf(entity), entity);


    }

    @Override
    public void delete(int id) {


        students.remove(getByID(id));
    }

    @Override
    public Student getByID(int id) {

        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
     }

     public List<Student> GetWhoPass(){
      List<Student>PassStudent=  students.stream().filter(student -> student.getScore()>50).toList();
        return PassStudent;
     }
     public Student GetTheFirstOneRanked(){
         Student RankOne = students.stream()
                 .max(Comparator.comparing(Student::getScore))
                 .orElse(null);
    return  RankOne;
    }


    @Override
    public List<Student> getAll() {
        return students;
    }

}
