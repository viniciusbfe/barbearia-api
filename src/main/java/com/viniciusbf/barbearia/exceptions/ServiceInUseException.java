package com.viniciusbf.barbearia.exceptions;

public class ServiceInUseException extends RuntimeException{

    public ServiceInUseException(String mensagem){
        super(mensagem);
    }
}
