package com.hospital.entitys.repository;

import com.hospital.entitys.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    List<Contacto> findByPersonaId(Long personaId);
}