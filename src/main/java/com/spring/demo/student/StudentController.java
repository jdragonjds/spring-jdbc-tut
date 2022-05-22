package com.spring.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping
    public void registerNewStudents(@RequestBody @Valid Student student) {
        studentService.addNewStudent(student);
    }
    @GetMapping(path="{studentId}")
    public List<StudentCourse> getAllCourseForStudent(@PathVariable UUID studentId){
        return studentService.getAllCourseForStudent(studentId);
    }
}
