package com.arquitectura.aplicaciones.config;

import com.arquitectura.aplicaciones.models.HealthAlert;
import com.arquitectura.aplicaciones.models.HealthAlertDTO;
import com.arquitectura.aplicaciones.models.HealthInstance;
import com.arquitectura.aplicaciones.models.HealthInstanceDTO;
import com.arquitectura.aplicaciones.models.enums.Alerts;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class Utils {

    public HealthAlertDTO toHealthAlertDTO(HealthAlert healthAlert) {
        HealthAlertDTO healthAlertDTO = new HealthAlertDTO();
        Random random = new Random();
        healthAlertDTO.setAlertType(Alerts.values()[random.nextInt(Alerts.values().length+1)].getName());
        healthAlertDTO.setDefinedUser(healthAlert.getHealthInstance().getName() + healthAlert.getHealthInstance().getSurname());
        healthAlertDTO.setSended(true);
        return healthAlertDTO;
    }

    public HealthInstanceDTO toHealthInstanceDTO(HealthInstance healthInstance) {
        HealthInstanceDTO healthInstanceDTO = new HealthInstanceDTO();
        healthInstanceDTO.setFull_name(healthInstance.getName() + healthInstance.getSurname());
        healthInstanceDTO.setBlood_pressure(String.valueOf(healthInstance.getBloodPressure()));
        healthInstanceDTO.setTimestamp(LocalDateTime.now().toString());
        healthInstanceDTO.setHeartbeats(String.valueOf(healthInstance.getHeartbeat()));
        healthInstanceDTO.setCritical(String.valueOf(healthInstance.getHeartbeat() <= 50));
        return healthInstanceDTO;
    }
}
