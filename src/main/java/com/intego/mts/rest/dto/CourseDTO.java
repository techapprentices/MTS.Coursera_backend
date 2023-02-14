package com.intego.mts.rest.dto;

import com.intego.mts.models.Module;
import com.intego.mts.models.User;
import com.intego.mts.models.enumeration.ECategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
public class CourseDTO {

    private UUID id;

    private String title;

    private String content;

    private Date creationDate;

    private User creator;

    private User author;

    private Time leadTime;

    private String rating;

    private Set<Module> modules;

    private String category;
}
