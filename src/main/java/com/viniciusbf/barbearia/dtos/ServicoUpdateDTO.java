package com.viniciusbf.barbearia.dtos;

public class ServicoUpdateDTO {

    private Integer duracao;
    private Double preco;

    public ServicoUpdateDTO(Integer duracao, Double preco) {
        this.duracao = duracao;
        this.preco = preco;
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
