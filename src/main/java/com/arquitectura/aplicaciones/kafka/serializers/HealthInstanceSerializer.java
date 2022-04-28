package com.arquitectura.aplicaciones.kafka.serializers;

import com.arquitectura.aplicaciones.models.HealthInstance;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.yaml.snakeyaml.serializer.SerializerException;

import java.util.Map;

public class HealthInstanceSerializer implements Serializer<HealthInstance> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        //Sonar
    }

    @Override
    public byte[] serialize(String s, HealthInstance healthInstance) {
        try {
            if (healthInstance == null){
                System.out.println("HealthInstance is null");
                return null;
            }
            System.out.println("Serializando");
            byte[] bytes = objectMapper.writeValueAsBytes(healthInstance);
            return bytes;
        } catch (Exception e) {
            throw new SerializerException("Error while serialazing HealthInstance");
        }
    }

    @Override
    public void close() {
        //Sonar
    }
}
