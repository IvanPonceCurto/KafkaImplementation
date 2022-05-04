package com.arquitectura.aplicaciones.models.enums;

public enum Alerts {
    PC_1("Paro Cardiaco nivel 1", 100, "CARDIOLOGÍA"),
    PCR("Paro Cardio respiratorio nivel 1", 100, "CARDIOLOGÍA,"),
    EEP("Estabilización estado paciente", 50, "CLINICA_MEDICA"),
    MEP("Mejora estado del paciente", 1, "CARDIOLOGÍA,CLINICA_MEDICA"),
    AEEP("Alerta, empeoró estado paciente", 100, "CARDIOLOGÍA,CLINICA_MEDICA,NEUROCIRUGÍA");

    private String name;
    private int value;
    private String channelAlerts;

    Alerts(String name, int value, String channelAlerts) {
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

    public int getValue() {
        return value;
    }

    public String getChannelAlerts() {
        return channelAlerts;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", channelAlerts='" + channelAlerts + '\'' +
                '}';
    }
}
