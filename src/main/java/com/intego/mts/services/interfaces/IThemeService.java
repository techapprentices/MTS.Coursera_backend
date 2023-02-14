package com.intego.mts.services.interfaces;

import com.intego.mts.models.Theme;

import java.util.List;
import java.util.UUID;

public interface IThemeService {
    Theme findById(UUID id);

    List<Theme> findAll();

    Theme save(Theme theme);

    void update(Theme theme);

    Theme delete(UUID id);
}
