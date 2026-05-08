package com.viniciusbf.barbearia.exceptions;

public class BarbeiroEmUsoException extends RuntimeException{

    public BarbeiroEmUsoException(String mensagem){
        super(mensagem);
    }
}
