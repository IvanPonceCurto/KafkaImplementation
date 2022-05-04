package com.arquitectura.aplicaciones.kafka;

import com.arquitectura.aplicaciones.config.Utils;
import com.arquitectura.aplicaciones.models.HealthAlert;
import com.arquitectura.aplicaciones.models.HealthInstance;
import com.arquitectura.aplicaciones.services.AsyncDB;
import com.arquitectura.aplicaciones.services.HealthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    //Escucha al topico que nosotros le definimos.
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private Utils utils;

    @Autowired
    private HealthService healthService;

    @Autowired
    private AsyncDB asyncDB;

    @KafkaListener(topics = "healthInstance", groupId = "healthInstaceId")
    void healthInstanceListener(String healthInstance) throws JsonProcessingException {
        System.out.println("escuchando al instance!");
        System.out.println("HealthInstance: "+healthInstance);
        asyncDB.saveInstanceDB(objectMapper.readValue(healthInstance, HealthInstance.class));
        //Sería enviarlo a el topic nuevo de el otro broker, que esto lo haríamos a nivel de controller
        //Guardarlo en la base que lo haría este
    }

    @KafkaListener(topics = "healthAlert", groupId = "healthAlertId")
    void healthAlertListener(String healthAlert) throws JsonProcessingException {
        System.out.println("HealthAlert: "+healthAlert);
        asyncDB.saveInstanceDB(objectMapper.readValue(healthAlert, HealthAlert.class));
        //healthService.saveHealthAlert(utils.toHealthAlertDTO(healthAlert));
    }

    @KafkaListener(topics = "genericAlert", groupId = "ejemploId")
    void genericListener(String objetoParsear) throws JsonProcessingException {
        System.out.println("Del Listener: " + objectMapper.readValue(objetoParsear, HealthAlert.class).toString());
    }
}
