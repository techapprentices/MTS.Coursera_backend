package com.intego.mts.rest.mapper;

import com.intego.mts.models.Theme;
import com.intego.mts.rest.dto.ThemeDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ThemeMapper {
    Theme dtoToEntity(ThemeDTO dto);

    ThemeDTO entityToDto(Theme entity);
}
