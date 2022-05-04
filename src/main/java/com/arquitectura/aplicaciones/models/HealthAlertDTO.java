package com.arquitectura.aplicaciones.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "health_alert")
public class HealthAlertDTO {

    @Id
    private String id;

    @Column(name = "sended")
    private boolean sended;

    @Column(name = "alert_type")
    private String alertType;

    @Column(name = "user_alerted")
    private String definedUser;
}
