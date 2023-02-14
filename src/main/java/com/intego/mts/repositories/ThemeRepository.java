package com.intego.mts.repositories;

import com.intego.mts.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, UUID> {
}
