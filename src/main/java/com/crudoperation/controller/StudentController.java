package com.crudoperation.controller;

import com.crudoperation.entity.Student;
import com.crudoperation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("add")
    public ResponseEntity<Student>createStudent(@RequestBody Student student){
        Student student1 = studentService.addStudent (student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }
    @GetMapping("/findAllStudent")
    public ResponseEntity<List<Student>>findAllStudent(){
        List<Student> student1 = studentService.findAllStudent();
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }
    @GetMapping("/findById")
    public ResponseEntity<Optional<Student>>findById(@RequestParam Long id){
        Optional<Student> student1 = studentService.findById(id);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }
    @PutMapping("/UpdateStudent")
    public ResponseEntity<Student>updateStudent(@RequestBody Student student, @RequestParam  Long id){
        Student student1 = studentService.updateStudent(student ,id);
        return new ResponseEntity<>(student1,HttpStatus.OK);

    }
    @DeleteMapping("/deleteStudent")
    public void deleteStudent(@RequestParam Long id){
         studentService.deleteById(id);
    }
}
