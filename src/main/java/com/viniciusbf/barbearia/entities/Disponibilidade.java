package com.viniciusbf.barbearia.entities;

import com.viniciusbf.barbearia.entities.enums.DiaSemana;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "tb_disponibilidades")
public class Disponibilidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Barbeiro barbeiro;
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Disponibilidade() {
    }

    public Disponibilidade(Integer id, Barbeiro barbeiro, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFim) {
        this.id = id;
        this.barbeiro = barbeiro;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
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
