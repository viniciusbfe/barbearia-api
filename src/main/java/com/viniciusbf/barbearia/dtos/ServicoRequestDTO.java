package com.viniciusbf.barbearia.dtos;

public class ServicoRequestDTO {

    private String nome;
    private Integer duracao;
    private Double preco;

    public ServicoRequestDTO() {
    }

    public ServicoRequestDTO(String nome, Integer duracao, Double preco) {
        this.nome = nome;
        this.duracao = duracao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
