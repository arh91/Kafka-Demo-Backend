package com.example.kafka.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Crea un constructor vacío.
@AllArgsConstructor // Crea un constructor con todos los parámetros.
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false)
    private String remitente;

}
