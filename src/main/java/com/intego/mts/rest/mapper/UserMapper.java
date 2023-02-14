package com.intego.mts.rest.mapper;

import com.intego.mts.models.User;
import com.intego.mts.rest.dto.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    User dtoToEntity(UserDTO dto);

    UserDTO entityToDto(User entity);
}
