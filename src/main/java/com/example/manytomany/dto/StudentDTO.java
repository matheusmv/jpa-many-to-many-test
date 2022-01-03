package com.example.manytomany.dto;

import com.example.manytomany.domain.Student;

public record StudentDTO(
        Long id,
        String name) {

    public StudentDTO(Student student) {
        this(student.getId(), student.getName());
    }
}
