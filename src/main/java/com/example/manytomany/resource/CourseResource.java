package com.example.manytomany.resource;

import com.example.manytomany.dto.CourseDTO;
import com.example.manytomany.dto.CourseWithStudentsDTO;
import com.example.manytomany.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseResource {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        var listOfCourses = courseService.findAll();

        return ResponseEntity.ok().body(listOfCourses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseWithStudentsDTO> findById(@PathVariable Long id) {
        var courseWithStudents = courseService.getCourseWithStudents(id);

        return ResponseEntity.ok().body(courseWithStudents);
    }
}
