package com.hospital.services.service;

import com.hospital.entitys.Contacto;

import java.util.List;

public interface ContactoService {
    List<Contacto> listarContactosPorPersona(Long personaId);
    void guardarContacto(Contacto contacto);
    void eliminarContacto(Long id);
}
