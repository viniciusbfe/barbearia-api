package com.viniciusbf.barbearia.dtos;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public class AgendamentoRequestDTO {

    @NotNull
    private Integer barbeiroId;
    @NotNull
    private Integer clienteId;
    @NotNull
    private LocalDateTime dataHora;
    @NotNull
    @NotEmpty
    private Set<Integer> servicoIds;

    public Integer getBarbeiroId() {
        return barbeiroId;
    }

    public void setBarbeiroId(Integer barbeiroId) {
        this.barbeiroId = barbeiroId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Set<Integer> getServicoIds() {
        return servicoIds;
    }
}
