package com.arquitectura.aplicaciones.repository;

import com.arquitectura.aplicaciones.models.HealthAlertDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHealthAlertRepository extends JpaRepository<HealthAlertDTO, Long> {

    @Override
    List<HealthAlertDTO> findAll();
}
