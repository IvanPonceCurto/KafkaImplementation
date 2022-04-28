package com.arquitectura.aplicaciones;

import com.arquitectura.aplicaciones.models.HealthInstance;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ArquitecturaDeAplicacionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquitecturaDeAplicacionesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, HealthInstance> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send("healthInstance", new HealthInstance("ivan","ok","ok"));
        };
    }
}
