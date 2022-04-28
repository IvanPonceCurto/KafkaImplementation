package com.arquitectura.aplicaciones.config;

import com.arquitectura.aplicaciones.kafka.serializers.HealthAlertSerializer;
import com.arquitectura.aplicaciones.kafka.serializers.HealthInstanceSerializer;
import com.arquitectura.aplicaciones.models.HealthAlert;
import com.arquitectura.aplicaciones.models.HealthInstance;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaProducerConfig {

    //Puedo definir multiples producers, sería replicar la configuracion necesaria en c/u

    @Value("${spring.kafka.bootstrap-servers}")
    private String serverBootstrapped;


    //Producer Factory --> Genera instancias de producers, con la configuracion de arriba
    //Aca es igual, si yo mando un objeto ponele, seria la clase de ese objeto
    @Bean
    public ProducerFactory<String, HealthInstance> healthInstanceProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverBootstrapped); //cambia s/ los producers que tengamos
        //En realidad, aca definis el Serializer por tipo de variable
        //Si vos mandas un evento que sea String, Numero, el segundo seria IntegerSerializar ponele
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, HealthInstanceSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    //Lo que nos permite mandar mensajes
    @Bean(name = "healthInstanceProducer")
    public KafkaTemplate<String, HealthInstance> healthInstanceKafkaTemplate(ProducerFactory<String, HealthInstance> healthInstanceProducerFactory) {
        return new KafkaTemplate<>(healthInstanceProducerFactory);
    }

    /*@Bean
    public ProducerFactory<String, Object> healthAlertProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "nombre instancia 2");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, HealthAlertSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }

    //@Bean(name = "healthAlertProducer")
    public KafkaTemplate<String, Object> healthAlertKafkaTemplate(ProducerFactory<String, Object> healthAlertProducerFactory) {
        return new KafkaTemplate<>(healthAlertProducerFactory);
    }*/


}
