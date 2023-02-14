package com.intego.mts.services.interfaces;

import com.intego.mts.models.User;
import com.intego.mts.rest.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
public interface IUserService {
    User findById(UUID id);

    List<User> findAll();

    User save(User user);

    void update(User user);

    void delete(UUID id);
}
