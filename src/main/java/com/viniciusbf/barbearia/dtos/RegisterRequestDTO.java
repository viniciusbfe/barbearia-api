package com.viniciusbf.barbearia.dtos;

import com.viniciusbf.barbearia.entities.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequestDTO {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String senha;
    @NotNull
    private Role role;

    public RegisterRequestDTO() {
    }

    public RegisterRequestDTO(String nome, String email, String senha, Role role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
