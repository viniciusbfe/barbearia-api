package com.viniciusbf.barbearia.entities;

import com.viniciusbf.barbearia.entities.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataHora;
    private LocalDateTime dataHoraFim;
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Barbeiro barbeiro;
    @ManyToMany
    private Set<Servico> servicos = new HashSet<>();
    private Double valorTotal;

    public Agendamento() {
    }

    public Agendamento(Integer id, LocalDateTime dataHora, LocalDateTime dataHoraFim,StatusAgendamento status, Cliente cliente, Barbeiro barbeiro, Double valorTotal){
        this.id = id;
        this.dataHora = dataHora;
        this.dataHoraFim = dataHoraFim;
        this.status = status;
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Set<Servico> getServicos() {
        return servicos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
