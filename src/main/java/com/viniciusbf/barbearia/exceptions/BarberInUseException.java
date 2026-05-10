package com.viniciusbf.barbearia.exceptions;

public class BarberInUseException extends RuntimeException{

    public BarberInUseException(String mensagem){
        super(mensagem);
    }
}
