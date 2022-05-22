package com.spring.demo.student;

import com.spring.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class StudentService {
    private final StudentDataAccessService studentDataAccessService;
    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;
    }
    private static final Predicate<String> IS_EMAIL_VALID =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).asPredicate();

    public List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }
    public void addNewStudent(Student student) {
       addNewStudent(null,student);
    }
    public void addNewStudent(UUID studentId , Student student) {
        UUID uuid= Optional.ofNullable(studentId).orElse(UUID.randomUUID());
        if(!IS_EMAIL_VALID.test(student.getEmail())){
            throw new ApiRequestException("wrong email");
        }
        Optional<Student> studentOptional=studentDataAccessService.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())throw new ApiRequestException("student with email already exists");
        studentDataAccessService.saveStudent(uuid, student);
    }

    public List<StudentCourse> getAllCourseForStudent(UUID studentId) {
        return studentDataAccessService.selectAllStudentCourses(studentId);
    }
}
