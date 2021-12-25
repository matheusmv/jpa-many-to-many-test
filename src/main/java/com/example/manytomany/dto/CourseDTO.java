package com.example.manytomany.dto;

import com.example.manytomany.domain.Course;

public class CourseDTO {

    private Long id;
    private String name;

    public CourseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseDTO(Course course) {
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
}
