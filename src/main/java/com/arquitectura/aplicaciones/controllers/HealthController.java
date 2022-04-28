package com.arquitectura.aplicaciones.controllers;

import com.arquitectura.aplicaciones.models.HealthAlert;
import com.arquitectura.aplicaciones.models.HealthInstance;
import com.arquitectura.aplicaciones.models.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {

    @Autowired
    private KafkaTemplate<String, HealthInstance> kafkaTemplate;



    //El otro consumer es el que tenemos en la terminal

    @PostMapping(value = "/status")
    public void writeToQueue(@RequestBody HealthInstance msg) {
        kafkaTemplate.send("healthInstance", msg);
    }

    @PostMapping(value = "/alert")
    public void postHealthInstanceController(@RequestBody HealthAlert healthAlert) {
        System.out.println("Alert");
        //healthAlertKafkaTemplate.send("healthAlert",healthAlert);
    }

    @PostMapping(value = "/instance")
    public void postHealthInstanceController(@RequestBody HealthInstance healthInstance) {
        System.out.println("Instance");
        //healthInstanceKafkaTemplate.send("healthInstance",healthInstance);
    }

}
