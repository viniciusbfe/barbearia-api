package com.viniciusbf.barbearia.entities.enums;

import java.time.DayOfWeek;

public enum DiaSemana {

    SEGUNDA_FEIRA,
    TERCA_FEIRA,
    QUARTA_FEIRA,
    QUINTA_FEIRA,
    SEXTA_FEIRA,
    SABADO,
    DOMINGO;

    public static DiaSemana fromDayOfWeek(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> SEGUNDA_FEIRA;
            case TUESDAY -> TERCA_FEIRA;
            case WEDNESDAY -> QUARTA_FEIRA;
            case THURSDAY -> QUINTA_FEIRA;
            case FRIDAY -> SEXTA_FEIRA;
            case SATURDAY -> SABADO;
            case SUNDAY -> DOMINGO;
        };
    }
}
