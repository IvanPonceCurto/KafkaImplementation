package com.arquitectura.aplicaciones.controllers;

import com.arquitectura.aplicaciones.models.HealthAlert;
import com.arquitectura.aplicaciones.models.HealthInstance;
import com.arquitectura.aplicaciones.services.AsyncDB;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {

    @Autowired
    private KafkaTemplate<String, HealthInstance> healthInstanceKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, HealthAlert> healthAlertKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, String> genericStringTemplate;

    @Autowired
    private AsyncDB asyncDB;


    private final ObjectMapper objectMapper = new ObjectMapper();



    @PostMapping(value = "/instance")
    public void writeToQueue(@RequestBody HealthInstance healthInstance) throws JsonProcessingException {
        healthInstanceKafkaTemplate.send("healthInstance", healthInstance);
        genericStringTemplate.send("IRTHealthData", objectMapper.writeValueAsString(healthInstance));

    }

    @PostMapping(value = "/alert")
    public void postHealthInstanceController(@RequestBody HealthAlert healthAlert) throws JsonProcessingException {
        healthAlertKafkaTemplate.send("healthAlert", healthAlert);
        genericStringTemplate.send("IRTHealthAlert", objectMapper.writeValueAsString(healthAlert));

    }

    @PostMapping(value = "/generic")
    public void genericTest(@RequestBody HealthAlert healthAlert) throws JsonProcessingException {
        System.out.println(healthAlert);
        //Sería, en paralelo, guardar en la base para que tomen del registro de histórico para la solución completa.
        //Y que le pegue el send al topico en cuestión.
        genericStringTemplate.send("IRTHealthData", objectMapper.writeValueAsString(healthAlert));
        genericStringTemplate.send("IRTHealthAlert",objectMapper.writeValueAsString(healthAlert));
        System.out.println("Las particiones definidas para los nuevos son: "+genericStringTemplate.partitionsFor("healthAlert"));
    }




}
