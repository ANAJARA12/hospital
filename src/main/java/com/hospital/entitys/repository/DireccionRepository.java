package com.hospital.entitys.repository;

import com.hospital.entitys.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    List<Direccion> findByPersonaId(Long personaId);
}
