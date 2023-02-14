package com.intego.mts.rest.mapper;

import com.intego.mts.models.Course;
import com.intego.mts.rest.dto.CourseDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CourseMapper {
    @Mapping( target = "category.title", source = "category")
    Course dtoToEntity(CourseDTO dto);
    @Mapping(target = "category", source = "category.title")
    CourseDTO entityToDto(Course entity);
}
