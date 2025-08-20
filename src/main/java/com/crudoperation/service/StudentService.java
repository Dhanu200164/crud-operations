package com.crudoperation.service;

import com.crudoperation.entity.Student;
import com.crudoperation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        Student studnet1 = studentRepository.save(student);
        return studnet1;
    }
    public List<Student> findAllStudent(){
       List<Student>  student1 = studentRepository.findAll();
        return student1;
    }
    public Optional<Student> findById(Long id){
       Optional<Student> student1 =  studentRepository.findById(id);
       return student1;
    }
    public Student updateStudent(Student student, Long id){
        Student student1 = studentRepository.findById(id).get();
        student1.setPassword("123456");
        Student updatedStudent = studentRepository.save(student);
        return updatedStudent;
    }
    public void deleteById(Long id){
         studentRepository.deleteById(id);
    }
}
