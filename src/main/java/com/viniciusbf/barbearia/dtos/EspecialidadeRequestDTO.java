package com.viniciusbf.barbearia.dtos;

public class EspecialidadeRequestDTO {

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
