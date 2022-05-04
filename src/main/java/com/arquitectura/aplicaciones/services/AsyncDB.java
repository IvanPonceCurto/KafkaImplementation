package com.arquitectura.aplicaciones.services;

import com.arquitectura.aplicaciones.config.Utils;
import com.arquitectura.aplicaciones.models.HealthAlert;
import com.arquitectura.aplicaciones.models.HealthAlertDTO;
import com.arquitectura.aplicaciones.models.HealthInstance;
import com.arquitectura.aplicaciones.models.HealthInstanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncDB {

    @Autowired
    private HealthService healthService;

    @Autowired
    private Utils utils;

    private final String HEALTH_ALERT = HealthAlert.class.getName();


    @Async
    public void saveInstanceDB(Object o) {
        System.out.println(o.getClass().getName().equals(HEALTH_ALERT));
        try {
            if (o.getClass().getName().equals(HEALTH_ALERT)) {
                HealthAlertDTO healthAlertDTO = utils.toHealthAlertDTO((HealthAlert) o);
                healthAlertDTO.setId(healthService.retrieveId(2));
                healthService.saveHealthAlert(healthAlertDTO);
            } else {
                HealthInstanceDTO healthInstanceDTO = utils.toHealthInstanceDTO((HealthInstance) o);
                healthInstanceDTO.setId(healthService.retrieveId(1));
                healthService.saveHealthInstance(healthInstanceDTO);
            }

        } catch (Exception e) {
            System.err.println("XX - Error insertando en la base" + e);
        }

    }
}
