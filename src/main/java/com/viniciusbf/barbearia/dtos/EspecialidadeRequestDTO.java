package com.viniciusbf.barbearia.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EspecialidadeRequestDTO {

    @NotNull
    @NotBlank
    private String nome;

    public EspecialidadeRequestDTO() {
    }

    public EspecialidadeRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
