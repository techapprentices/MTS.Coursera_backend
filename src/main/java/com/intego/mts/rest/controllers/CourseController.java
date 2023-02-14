package com.intego.mts.rest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intego.mts.rest.dto.CourseDTO;
import com.intego.mts.rest.mapper.CourseMapper;
import com.intego.mts.services.interfaces.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("rest/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    private final CourseMapper courseMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById (@NonNull @PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(courseMapper.entityToDto(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(course -> courseMapper.entityToDto(course)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO dto) {
        CourseDTO createdDto = courseMapper.entityToDto(service.save(courseMapper.dtoToEntity(dto)));
        return ResponseEntity.created(URI.create("http://localhost:8080/rest/v1/courses/" + createdDto.getId().toString())).body(createdDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDTO> deleteCourse(@PathVariable UUID id){
        return ResponseEntity.ok().body(courseMapper.entityToDto(service.delete(id)));
    }
}
