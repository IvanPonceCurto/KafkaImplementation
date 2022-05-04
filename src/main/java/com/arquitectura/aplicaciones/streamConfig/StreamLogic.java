package com.arquitectura.aplicaciones.streamConfig;

import com.arquitectura.aplicaciones.models.HealthAlert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class StreamLogic {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //@Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> messageStream = streamsBuilder.stream("healthAlert");
        messageStream.foreach((e, e2) -> {
            //Nos llega un json como String, por problemas en deserializar, así lo que manejamos adentro
            try {
                HealthAlert healthAlert = objectMapper.readValue(e, HealthAlert.class);
                System.out.println("El alert es: " + healthAlert.toString());
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        });
        messageStream.to("IRTHealthAlert");
    }
}
