package com.example.manytomany.resource.response;

import com.example.manytomany.domain.Course;

public class CourseResponse {

    private Long id;
    private String name;

    public CourseResponse(Course course) {
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
