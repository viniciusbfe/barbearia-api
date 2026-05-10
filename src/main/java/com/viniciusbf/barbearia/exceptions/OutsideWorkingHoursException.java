package com.viniciusbf.barbearia.exceptions;

public class OutsideWorkingHoursException extends RuntimeException {

    public OutsideWorkingHoursException(String mensagem){
        super(mensagem);
    }
}
