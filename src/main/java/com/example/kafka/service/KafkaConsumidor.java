package com.example.kafka.service;

import com.example.kafka.model.Mensaje;
import com.example.kafka.repository.MensajeRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumidor {
    private final MensajeRepository mensajeRepository;

    public KafkaConsumidor(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @KafkaListener(topics = "spring-kafka", groupId = "grupo-demo")
    public void escucharMensajes(String contenido) {
        Mensaje mensaje = new Mensaje();
        mensaje.setContenido(contenido);
        mensaje.setRemitente("Usuario");
        mensajeRepository.save(mensaje);
        System.out.println("Mensaje recibido y guardado en BD: " + contenido);
    }
}
