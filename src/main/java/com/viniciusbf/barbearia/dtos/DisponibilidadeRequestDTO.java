package com.viniciusbf.barbearia.dtos;

import com.viniciusbf.barbearia.entities.enums.DiaSemana;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class DisponibilidadeRequestDTO {

    @NotNull
    private Integer barbeiroId;
    @NotNull
    private DiaSemana diaSemana;
    @NotNull
    private LocalTime horaInicio;
    @NotNull
    private LocalTime horaFim;

    public DisponibilidadeRequestDTO() {
    }

    public DisponibilidadeRequestDTO(Integer barbeiroId, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFim) {
        this.barbeiroId = barbeiroId;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Integer getBarbeiroId() {
        return barbeiroId;
    }

    public void setBarbeiroId(Integer barbeiroId) {
        this.barbeiroId = barbeiroId;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
