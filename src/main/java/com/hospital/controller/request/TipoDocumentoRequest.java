package com.hospital.controller.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoRequest {
    private Long id;
    private String sigla;
    private String descripcion;
}
