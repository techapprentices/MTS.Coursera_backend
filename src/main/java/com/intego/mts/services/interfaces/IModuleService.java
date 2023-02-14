package com.intego.mts.services.interfaces;

import com.intego.mts.models.Module;

import java.util.List;
import java.util.UUID;

public interface IModuleService {
    Module findById(UUID id);

    List<Module> findAll();

    Module save(Module module);

    void update(Module module);

    Module delete(UUID id);
}
