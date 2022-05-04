package com.arquitectura.aplicaciones.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "health_instance")
public class HealthInstanceDTO {

    @Id
    private String id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "blood_pressure")
    private String blood_pressure;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "heartbeats")
    private String heartbeats;

    @Column(name = "critical")
    private String critical;
}
