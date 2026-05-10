package com.viniciusbf.barbearia.dtos;

import jakarta.validation.constraints.NotNull;

public class ClienteRequestDTO {

    @NotNull
    private String nome;
    @NotNull
    private String telefone;
    @NotNull
    private String email;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
