package com.example.manytomany.resource.response;

import com.example.manytomany.domain.Student;

public class StudentResponse {

    private Long id;
    private String name;

    public StudentResponse(com.example.manytomany.domain.Student student) {
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
}
