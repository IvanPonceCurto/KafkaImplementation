package com.arquitectura.aplicaciones.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthInstance {
    //Serializar, sería el proceso por el cual nosotros el objeto Java lo pasamos a bytes para enviarlo entre capas
    //y que kafka lo pueda entender.

    private String labelName;
    private String healthOk;
    private String healthNotOk;

}
