package com.example.manytomany.resource;

import com.example.manytomany.dto.EnrollInCourseDTO;
import com.example.manytomany.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
public class CourseRegistrationResource {

    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @PostMapping
    public ResponseEntity<Void> enrollInCourse(@RequestBody EnrollInCourseDTO enrollInCourseDTO) {
        courseRegistrationService.insert(enrollInCourseDTO.toRegistration());

        return ResponseEntity.noContent().build();
    }
}
