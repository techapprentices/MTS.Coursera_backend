package com.intego.mts.rest.mapper;

import com.intego.mts.models.Module;
import com.intego.mts.rest.dto.ModuleDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ModuleMapper {

    Module dtoToEntity(ModuleDTO dto);

    ModuleDTO entityToDto(Module entity);
}
