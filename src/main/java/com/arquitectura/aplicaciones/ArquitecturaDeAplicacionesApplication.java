package com.arquitectura.aplicaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ArquitecturaDeAplicacionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquitecturaDeAplicacionesApplication.class, args);
    }

    /*@Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, HealthInstance> kafkaTemplate, KafkaTemplate<String, HealthAlert> kafkaTemplateAlert) {
        return args -> {

            kafkaTemplate.send("healthInstance", new HealthInstance("ivan","ok","ok"));
            kafkaTemplateAlert.send("healthAlert",new HealthAlert(true, Alerts.MEP, new Timestamp(System.currentTimeMillis()).toString()));

        };
    }*/

}
