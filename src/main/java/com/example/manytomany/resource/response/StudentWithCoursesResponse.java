package com.example.manytomany.resource.response;

import com.example.manytomany.domain.Student;

import java.util.List;

public class StudentWithCoursesResponse {

    private Long id;
    private String name;
    private List<CourseResponse> courses;

    public StudentWithCoursesResponse(Student student) {
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

    public List<CourseResponse> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseResponse> courses) {
        this.courses = courses;
    }
}
