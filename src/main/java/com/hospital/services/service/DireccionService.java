package com.hospital.services.service;

import com.hospital.entitys.Direccion;

import java.util.List;

public interface DireccionService {
    List<Direccion> listarDireccionesPorPersona(Long personaId);
    void guardarDireccion(Direccion direccion);
    void eliminarDireccion(Long id);
}
