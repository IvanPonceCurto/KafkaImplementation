package com.arquitectura.aplicaciones.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthInstance {
    //Serializar, sería el proceso por el cual nosotros el objeto Java lo pasamos a bytes para enviarlo entre capas
    //y que kafka lo pueda entender.
    private String name;
    private String surname;
    private int age;
    private String medicalInsurance;
    private int heartbeat;
    private int bloodPressure;
    private long distanceFromHospital;
    private String designedHospital;

}
