package com.arquitectura.aplicaciones.models;

import com.arquitectura.aplicaciones.models.enums.Alerts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthAlert implements Serializable {
    private boolean state; //enviada o no
    private Alerts Alert;
    private String timestamp;

}
