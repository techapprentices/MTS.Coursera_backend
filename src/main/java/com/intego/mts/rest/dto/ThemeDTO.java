package com.intego.mts.rest.dto;

import com.intego.mts.models.Module;
import com.intego.mts.models.User;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
public class ThemeDTO {
    private UUID id;

    private String description;

    private Date creationDate;

    private User creator;

    private String textContent;

    private Set<Module> modules;
}
