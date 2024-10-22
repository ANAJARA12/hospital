package com.hospital.controller;

import com.hospital.entitys.Direccion;
import com.hospital.services.service.DireccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping("/persona/{personaId}")
    public List<Direccion> listarDireccionesPorPersona(@PathVariable Long personaId) {
        return direccionService.listarDireccionesPorPersona(personaId);
    }

    @PostMapping
    public void guardarDireccion(@RequestBody Direccion direccion) {
        direccionService.guardarDireccion(direccion);
    }

    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable Long id) {
        direccionService.eliminarDireccion(id);
    }
}