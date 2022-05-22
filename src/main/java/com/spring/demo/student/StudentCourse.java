package com.spring.demo.student;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

public class StudentCourse {

    private final UUID studentId;
    private final UUID courseId;
    @NotBlank
    private final String courseName;
    @NotBlank
    private final String department;
    private final String description;
    private final String instructor;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer grade;

    public StudentCourse(UUID studentId, UUID courseId, String courseName, String description, String department, String instructor, LocalDate startDate, LocalDate endDate, Integer grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.department = department;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grade = grade;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructor() {
        return instructor;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getGrade() {
        return grade;
    }
}
