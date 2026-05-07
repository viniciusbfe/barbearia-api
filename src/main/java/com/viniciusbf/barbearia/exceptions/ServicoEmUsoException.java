package com.viniciusbf.barbearia.exceptions;

public class ServicoEmUsoException extends RuntimeException{

    public ServicoEmUsoException(String mensagem){
        super(mensagem);
    }
}
