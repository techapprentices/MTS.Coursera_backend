package com.intego.mts.services.impl;

import com.intego.mts.exception.EntityNotFoundException;
import com.intego.mts.models.Course;
import com.intego.mts.models.Module;
import com.intego.mts.repositories.ModuleRepository;
import com.intego.mts.services.interfaces.IModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class ModuleService implements IModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public Module findById(UUID id) {
        return moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Module not found: id = " + id));
    }

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public void update(Module module) {

    }

    @Override
    public Module delete(UUID id) {
        Module module = moduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Module not found: id = " + id));
        moduleRepository.deleteById(id);
        return module;
    }
}
