package com.hospital.controller;

import com.hospital.controller.request.TipoDocumentoRequest;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.services.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-documento")
@RequiredArgsConstructor
public class TiposDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumentoResponse> listarTiposDocumento() {
        return tipoDocumentoService.listarTiposDeDocumentos().stream()
                .map(documento -> TipoDocumentoResponse.builder()
                        .id(documento.getId())
                        .sigla(documento.getSigla())
                        .descripcion(documento.getDescripcion())
                        .build())
                .toList();
    }

    @GetMapping("/{id}")
    public TipoDocumentoResponse obtenerTipoDocumentoPorId(@PathVariable Long id) {
        return tipoDocumentoService.consultarTiposDeDocumentos(id);
    }

    @PostMapping
    public void guardarTipoDocumento(@RequestBody TipoDocumentoRequest tipoDocumentoRequest) {
        tipoDocumentoService.guardarTiposDeDocumentos(tipoDocumentoRequest);
    }

    @PutMapping("/{id}")
    public void actualizarTipoDocumento(@PathVariable Long id, @RequestBody TipoDocumentoRequest tipoDocumentoRequest) {
        tipoDocumentoRequest.setId(id); // Asegurar que el ID sea el correcto
        tipoDocumentoService.actualizarTiposDeDocumentos(tipoDocumentoRequest);
    }

    @DeleteMapping("/{id}")
    public void eliminarTipoDocumento(@PathVariable Long id) {
        tipoDocumentoService.eliminarTiposDeDocumentos(id);
    }
}

