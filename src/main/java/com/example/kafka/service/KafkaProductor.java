package com.example.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProductor {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProductor(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensaje(String mensaje) {
        kafkaTemplate.send("spring-kafka", mensaje);
        System.out.println("Mensaje enviado a Kafka: " + mensaje);
    }
}
