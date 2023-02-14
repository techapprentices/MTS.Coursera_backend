package com.intego.mts.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intego.mts.models.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID id;
    @Length(min = 5, max = 100)
    @NotNull
    private String username;

    @JsonIgnore
    @NotNull
    private String password;

    @NotNull
    @JsonIgnore
    private Set<Role> roles;
}
