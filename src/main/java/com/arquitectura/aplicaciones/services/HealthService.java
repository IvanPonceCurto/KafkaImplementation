package com.arquitectura.aplicaciones.services;


import com.arquitectura.aplicaciones.models.HealthAlertDTO;
import com.arquitectura.aplicaciones.models.HealthInstanceDTO;
import com.arquitectura.aplicaciones.repository.IHealthAlertRepository;
import com.arquitectura.aplicaciones.repository.IHealthInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HealthService {

    @Autowired
    private IHealthAlertRepository iHealthAlertRepository;

    @Autowired
    private IHealthInstance iHealthInstance;

    @Transactional
    public void saveHealthAlert(HealthAlertDTO healthAlertDto) {
        System.out.println("XX- Guardando healthAlert");
        iHealthAlertRepository.save(healthAlertDto);
    }

    @Transactional
    public void saveHealthInstance(HealthInstanceDTO healthInstanceDTO) {
        System.out.println("XX - Guardando healthInstance");
        iHealthInstance.save(healthInstanceDTO);
    }

    @Transactional
    public String retrieveId(int opcion) {
        switch (opcion) {
            case 1:
                return String.valueOf(iHealthInstance.findAll().size());
            case 2:
                return String.valueOf(iHealthAlertRepository.findAll().size());
            default:
                return String.valueOf(LocalDateTime.now().toString().charAt(12));
        }
    }

}
