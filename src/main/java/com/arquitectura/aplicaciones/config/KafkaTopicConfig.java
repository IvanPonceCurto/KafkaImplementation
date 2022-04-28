package com.arquitectura.aplicaciones.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    //Clase responsable de crear los topicos

    //Creamos 2 topics mas, q son sobre los que vamos a escribir y escuchar.

    @Bean
    public NewTopic arqAppTopic() {
        return TopicBuilder.name("arqapp").build();
    }

    @Bean
    public NewTopic healthAlertTopic() {
        System.out.println("Creando HealthAlert topic");
        return TopicBuilder.name("healthAlert").build();
    }

    @Bean
    public NewTopic healthInstanceTopic() {
        System.out.println("Creando HealthInstance topic");
        return TopicBuilder.name("healthInstance").build();
    }
}
