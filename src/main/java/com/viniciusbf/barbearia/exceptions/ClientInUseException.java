package com.viniciusbf.barbearia.exceptions;

public class ClientInUseException extends RuntimeException{

    public ClientInUseException(String mensagem){
        super(mensagem);
    }
}
