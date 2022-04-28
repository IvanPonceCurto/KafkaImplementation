package com.arquitectura.aplicaciones.kafka.serializers;

import com.arquitectura.aplicaciones.models.HealthInstance;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

import java.util.Map;

public class HealthInstanceDeserializer implements Deserializer<HealthInstance> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        //Sonar
    }

    @Override
    public HealthInstance deserialize(String s, byte[] bytes) {
        try {
            if (bytes == null) {
                System.out.println("Cant deserialize smth null");
                return null;
            }
            System.out.println("Deserializando con "+bytes);
            return objectMapper.readValue(new String(bytes, "UTF-8"),
                    HealthInstance.class);
        } catch (Exception e) {
            throw new DeserializationException(
                    "Error while deserializing HealthInstance",
                    null,
                    false,
                    null
            );
        }
    }

    @Override
    public void close() {
        //Sonar
    }
}
