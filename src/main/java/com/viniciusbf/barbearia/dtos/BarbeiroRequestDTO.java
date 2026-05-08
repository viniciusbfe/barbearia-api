package com.viniciusbf.barbearia.dtos;

import java.util.HashSet;
import java.util.Set;

public class BarbeiroRequestDTO {

    private String nome;
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
