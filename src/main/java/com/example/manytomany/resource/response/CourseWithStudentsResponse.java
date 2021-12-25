package com.example.manytomany.resource.response;

import com.example.manytomany.domain.Course;

import java.util.List;

public class CourseWithStudentsResponse {

    private Long id;
    private String name;
    private List<StudentResponse> students;

    public CourseWithStudentsResponse(Course course) {
        this.id = course.getId();
        this.name = course.getName();
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

    public List<StudentResponse> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResponse> students) {
        this.students = students;
    }
}
