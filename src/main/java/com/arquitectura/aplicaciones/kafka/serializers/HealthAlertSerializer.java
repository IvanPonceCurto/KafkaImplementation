package com.arquitectura.aplicaciones.kafka.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.yaml.snakeyaml.serializer.SerializerException;

import java.util.Map;


public class HealthAlertSerializer implements Serializer {

    /*Es como un .json() de js, nos sirve para convertir de String a
    Json, o viceversa*/
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        //Comentario para sonar
    }

    @Override
    public byte[] serialize(String s, Object alert) {
        try {
            if (alert == null) {
                System.out.println("Incoming object is null");
                return null;
            }
            System.out.println("Starting serialization for HealthAlert");
            return objectMapper.writeValueAsBytes(alert);
        } catch (Exception e) {
            throw new SerializerException("Error parsing from object to byte - HealthAlert");
        }
    }

    @Override
    public void close() {

    }
}
