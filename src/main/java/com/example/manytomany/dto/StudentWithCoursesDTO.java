package com.example.manytomany.dto;

import com.example.manytomany.domain.Student;

import java.util.List;

public class StudentWithCoursesDTO {

    private Long id;
    private String name;
    private List<CourseDTO> courses;

    public StudentWithCoursesDTO(Long id, String name, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public StudentWithCoursesDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
