package com.intego.mts.rest.controllers;

import com.intego.mts.rest.dto.ThemeDTO;
import com.intego.mts.rest.mapper.ThemeMapper;
import com.intego.mts.services.interfaces.IThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/v1/themes")
@RequiredArgsConstructor
public class ThemeController {
    private final IThemeService service;
    private final ThemeMapper themeMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ThemeDTO> findById (@NonNull @PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(themeMapper.entityToDto(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ThemeDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(theme -> themeMapper.entityToDto(theme)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ThemeDTO> createCourse(@RequestBody ThemeDTO dto) {
        ThemeDTO createdDto = themeMapper.entityToDto(service.save(themeMapper.dtoToEntity(dto)));
        return ResponseEntity.created(URI.create("http://localhost:8080/rest/v1/themes/" + createdDto.getId().toString())).body(createdDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ThemeDTO> deleteCourse(@PathVariable UUID id){
        return ResponseEntity.ok().body(themeMapper.entityToDto(service.delete(id)));
    }
}
