package com.arquitectura.aplicaciones.config;

import com.arquitectura.aplicaciones.kafka.serializers.HealthInstanceDeserializer;
import com.arquitectura.aplicaciones.models.HealthInstance;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaConsumerConfig {

    //Creamos del lado del consumer, la ingesta de los mensajes

    @Value("${spring.kafka.bootstrap-servers}")
    private String serverBootstrapped;


    public Map<String, Object> consumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverBootstrapped);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "ejemploId");
        //props.put(ConsumerConfig.CLIENT_ID_CONFIG,"consumer-ejemploId-3");
        //En realidad, aca definis el Serializer por tipo de variable
        //Si vos mandas un evento que sea String, Numero, el segundo seria IntegerSerializar ponele
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //Lo que hace este earliest, es que se asegura que los producers hayan mandado todo antes ed empezar el consumer

        //Ponerle el groupId
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        //props.put(ConsumerConfig.GROUP_ID_CONFIG,"H");//Verlo bien, en teoría es que el generas especifico
        return props;
    }

    //Consumer y Producer Factory --> Genera instancias de producers y consumers, con la configuracion de arriba
    //Aca es igual, si yo mando un objeto ponele, seria la clase de ese objeto
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    //Como en el anterior mandabamos mensajes, en estos los tenemos que recibir.

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> factory(ConsumerFactory<String, String> consumerFactory) {
        //Recibe todos los mensajes o particiones de todos los topics, de un mismo thread
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    //Detallo 2 nuevos consumers para mi app.


}