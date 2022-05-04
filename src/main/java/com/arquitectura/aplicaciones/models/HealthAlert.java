package com.arquitectura.aplicaciones.models;

import com.arquitectura.aplicaciones.models.enums.Alerts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthAlert  {

    private boolean alertState;

    private HealthInstance healthInstance;

    private Alerts alerts; //En realidad aca sería guardar el objeto que nosotros mapeariamos correctamente.

    private String timestamp;

}
