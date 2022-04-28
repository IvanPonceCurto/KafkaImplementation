package com.arquitectura.aplicaciones.models.enums;

import java.util.Map;

public enum Alerts {
    ALERT1("Ivan", 1, null);

    private String name;
    private int value;
    private Map<String, Object> channelAlerts;

    Alerts(String name, int value, Map<String, Object> channelAlerts) {
        this.name = name;
        this.value = value;
        this.channelAlerts = channelAlerts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
