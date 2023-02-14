package com.intego.mts.services.impl;

import com.intego.mts.exception.EntityNotFoundException;
import com.intego.mts.exception.EntityUniquenessConstraintViolationException;
import com.intego.mts.models.Course;
import com.intego.mts.models.User;
import com.intego.mts.repositories.CourseRepository;
import com.intego.mts.repositories.UserRepository;
import com.intego.mts.rest.dto.CourseDTO;
import com.intego.mts.rest.mapper.CourseMapper;
import com.intego.mts.services.interfaces.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Validated
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseMapper mapper;

    @Override
    public Course findById(UUID id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found: id = " + id));
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
        /*return StreamSupport.stream(courseEntities.spliterator(), false)
                .map(mapper::entityToDto)
                .collect(Collectors.toList());*/
    }

    @Override
    public Course save(Course course) {
        @Valid Course finalCourse = course;
        User user = userRepository.findById(course.getAuthor().getId()).orElseThrow(() -> new EntityNotFoundException("User not found: username = " + finalCourse.getAuthor().getUsername()));
        try {
            course.setAuthor(user);
            course = courseRepository.save(course);
        } catch (DataIntegrityViolationException e) {
            throw new EntityUniquenessConstraintViolationException("Нарушение уникальности по полю" + ": " + e.getCause().getCause().getMessage());
        }
        return course;
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public Course delete(UUID id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found: id = " + id));
        courseRepository.deleteById(id);
        return course;
    }

}
