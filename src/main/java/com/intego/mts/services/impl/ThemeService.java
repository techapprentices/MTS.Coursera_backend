package com.intego.mts.services.impl;

import com.intego.mts.exception.EntityNotFoundException;
import com.intego.mts.models.Course;
import com.intego.mts.models.Theme;
import com.intego.mts.repositories.ThemeRepository;
import com.intego.mts.services.interfaces.IThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class ThemeService implements IThemeService {

    private final ThemeRepository themeRepository;

    @Override
    public Theme findById(UUID id) {
        return themeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theme not found: id = " + id));
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme save(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public void update(Theme theme) {

    }

    @Override
    public Theme delete(UUID id) {
        Theme theme = themeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found: id = " + id));
        themeRepository.deleteById(id);
        return theme;
    }
}
