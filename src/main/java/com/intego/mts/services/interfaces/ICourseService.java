package com.intego.mts.services.interfaces;

import com.intego.mts.models.Course;
import com.intego.mts.rest.dto.CourseDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
public interface ICourseService {
    Course findById(UUID id);

    List<Course> findAll();

    Course save(Course course);

    void update(Course course);

    Course delete(UUID id);
}
