package com.example.manytomany.service;

import com.example.manytomany.domain.CourseRegistration;
import com.example.manytomany.repository.CourseRegistrationRepository;
import com.example.manytomany.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegistrationService {

    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public CourseRegistrationService(
            CourseRegistrationRepository courseRegistrationRepository,
            CourseService courseService,
            StudentService studentService
    ) {
        this.courseRegistrationRepository = courseRegistrationRepository;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public CourseRegistration getById(Long id) {
        return courseRegistrationRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Object with id %d not found in %s.", id, CourseRegistration.class.getSimpleName())));
    }

    public void insert(CourseRegistration registration) {
        registration.setId(null);

        Long courseId = registration.getCourse().getId();
        registration.setCourse(courseService.find(courseId));

        Long studentId = registration.getStudent().getId();
        registration.setStudent(studentService.find(studentId));

        courseRegistrationRepository.save(registration);
    }
}
