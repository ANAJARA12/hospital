package com.hospital.controller;

import com.hospital.entitys.Contacto;
import com.hospital.services.service.ContactoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactoController {
    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping("/persona/{personaId}")
    public List<Contacto> listarContactosPorPersona(@PathVariable Long personaId) {
        return contactoService.listarContactosPorPersona(personaId);
    }

    @PostMapping
    public void guardarContacto(@RequestBody Contacto contacto) {
        contactoService.guardarContacto(contacto);
    }

    @DeleteMapping("/{id}")
    public void eliminarContacto(@PathVariable Long id) {
        contactoService.eliminarContacto(id);
    }
}