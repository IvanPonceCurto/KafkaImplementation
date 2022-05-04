package com.arquitectura.aplicaciones.repository;

import com.arquitectura.aplicaciones.models.HealthInstanceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHealthInstance extends JpaRepository<HealthInstanceDTO, Long> {

    @Override
    List<HealthInstanceDTO> findAll();
}
