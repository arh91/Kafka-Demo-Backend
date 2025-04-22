package com.example.kafka.controller;

import com.example.kafka.service.KafkaProductor;
import com.example.kafka.model.Mensaje;
import com.example.kafka.repository.MensajeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin("*")
public class MensajeController {
    private final KafkaProductor kafkaProductor;
    private final MensajeRepository mensajeRepository;

    public MensajeController(KafkaProductor kafkaProductor, MensajeRepository mensajeRepository) {
        this.kafkaProductor = kafkaProductor;
        this.mensajeRepository = mensajeRepository;
    }

    @PostMapping("/enviar")
    public void enviarMensaje(@RequestBody String mensaje) {
        kafkaProductor.enviarMensaje(mensaje);
    }

    @GetMapping("/listar")
    public List<Mensaje> obtenerMensajes() {
        return mensajeRepository.findAll();
    }
}
