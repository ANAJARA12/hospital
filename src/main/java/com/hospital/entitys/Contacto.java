package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "fk_persona", referencedColumnName = "id")
    private Persona persona;
}
