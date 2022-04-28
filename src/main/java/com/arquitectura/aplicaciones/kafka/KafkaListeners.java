package com.arquitectura.aplicaciones.kafka;

import com.arquitectura.aplicaciones.models.HealthAlert;
import com.arquitectura.aplicaciones.models.HealthInstance;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    //Escucha al topico que nosotros le definimos.

    @KafkaListener(topics = "arqapp",groupId = "ejemploId")
    void listener(String data){
        System.out.println("El dato es: "+data);
    }

    @KafkaListener(topics = "healthInstance",groupId = "ejemploId")
    void healthInstanceListener(HealthInstance healthInstance){
        System.out.println(healthInstance);
    }

    @KafkaListener(topics = "healthAlert",groupId = "ejemploId")
    void healthAlertListener(HealthAlert healthAlert){
        System.out.println(healthAlert);
    }
}
