package com.example.manytomany.dto;

import com.example.manytomany.domain.Student;

public class StudentDTO {

    private Long id;
    private String name;

    public StudentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentDTO(Student student) {
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
