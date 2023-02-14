package com.intego.mts.rest.dto;

import com.intego.mts.models.Course;
import com.intego.mts.models.Theme;
import com.intego.mts.models.User;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
public class ModuleDTO {

    private UUID id;

    private String title;

    private String description;

    private Date creationDate;

    private User creator;

    private Set<Course> courses;

    private Set<Theme> themes;
}
