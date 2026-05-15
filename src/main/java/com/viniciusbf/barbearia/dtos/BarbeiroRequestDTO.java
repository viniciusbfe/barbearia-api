package com.viniciusbf.barbearia.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class BarbeiroRequestDTO {

    @NotNull
    private String nome;
    @NotNull
    private Set<Integer> especialidades = new HashSet<>();

    public BarbeiroRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Integer> getEspecialidades() {
        return especialidades;
    }
}
