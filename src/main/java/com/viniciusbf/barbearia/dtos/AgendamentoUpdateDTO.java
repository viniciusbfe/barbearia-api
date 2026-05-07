package com.viniciusbf.barbearia.dtos;

import com.viniciusbf.barbearia.entities.enums.StatusAgendamento;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AgendamentoUpdateDTO {

    private LocalDateTime dataHora;
    private StatusAgendamento statusAgendamento;
    private Integer barbeiroId;
    private Set<Integer> servicoIds = new HashSet<>();

    public AgendamentoUpdateDTO() {
    }

    public AgendamentoUpdateDTO(LocalDateTime dataHora, StatusAgendamento statusAgendamento, Integer barbeiroId) {
        this.dataHora = dataHora;
        this.statusAgendamento = statusAgendamento;
        this.barbeiroId = barbeiroId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Integer getBarbeiroId() {
        return barbeiroId;
    }

    public void setBarbeiroId(Integer barbeiroId) {
        this.barbeiroId = barbeiroId;
    }

    public Set<Integer> getServicoIds() {
        return servicoIds;
    }
}
