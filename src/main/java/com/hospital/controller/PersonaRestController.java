package com.hospital.controller;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaRestController {

    private final PersonaService personaService;

    @GetMapping
    public List<PersonaResponse> listarPersonas() {
        return personaService.getListPersons().stream()
                .map(persona -> PersonaResponse.builder()
                        .id(persona.getId())
                        .nombre(persona.getNombre())
                        .apellido(persona.getApellido())
                        .build())
                .toList();
    }

    @GetMapping("/{id}")
    public PersonaResponse obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.searchPerson(id);
    }

    @PostMapping
    public void guardarPersona(@RequestBody PersonaRequest personaRequest) {
        personaService.savePerson(personaRequest);
    }

    @PutMapping("/{id}")
    public void actualizarPersona(@PathVariable Long id, @RequestBody PersonaRequest personaRequest) {
        personaRequest.setId(id); // Asegurar que el ID sea el correcto
        personaService.updatePerson(personaRequest);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.deletePerson(id);
    }
}
