package com.intego.mts.rest.controllers;

import com.intego.mts.rest.dto.ModuleDTO;
import com.intego.mts.rest.mapper.ModuleMapper;
import com.intego.mts.services.interfaces.IModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/v1/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final IModuleService service;
    private final ModuleMapper moduleMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> findById (@NonNull @PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(moduleMapper.entityToDto(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ModuleDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(module -> moduleMapper.entityToDto(module)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ModuleDTO> createCourse(@RequestBody ModuleDTO dto) {
        ModuleDTO createdDto = moduleMapper.entityToDto(service.save(moduleMapper.dtoToEntity(dto)));
        return ResponseEntity.created(URI.create("http://localhost:8080/rest/v1/modules/" + createdDto.getId().toString())).body(createdDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModuleDTO> deleteCourse(@PathVariable UUID id){
        return ResponseEntity.ok().body(moduleMapper.entityToDto(service.delete(id)));
    }
}
