package com.intego.mts.services.impl;

import com.intego.mts.exception.EntityNotFoundException;
import com.intego.mts.exception.EntityUniquenessConstraintViolationException;
import com.intego.mts.models.User;
import com.intego.mts.repositories.UserRepository;
import com.intego.mts.rest.dto.UserDTO;
import com.intego.mts.rest.mapper.UserMapper;
import com.intego.mts.services.interfaces.IUserService;
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
public class UserService implements IUserService {

    private final UserRepository repository;


    @Override
    public User findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found: id = " + id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        try {
            user = repository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new EntityUniquenessConstraintViolationException("Нарушение уникальности по полю" + ": " + e.getCause().getCause().getMessage());
        }
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(UUID id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("User not found: id = " + id);
        }
        repository.deleteById(id);
    }
}
