package com.intego.mts.rest.controllers;

import com.intego.mts.rest.dto.UserDTO;
import com.intego.mts.rest.mapper.UserMapper;
import com.intego.mts.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;
    private final UserMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById (@NonNull @PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(mapper.entityToDto(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll().stream().map(user -> mapper.entityToDto(user)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        UserDTO createdDto = mapper.entityToDto(service.save(mapper.dtoToEntity(dto)));
        return ResponseEntity.created(URI.create("http://localhost:8080/rest/v1/courses/" + createdDto.getId().toString())).body(createdDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        service.delete(id);
    }
}
