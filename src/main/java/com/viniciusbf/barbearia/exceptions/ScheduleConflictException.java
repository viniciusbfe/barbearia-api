package com.viniciusbf.barbearia.exceptions;

public class ScheduleConflictException extends RuntimeException{

    public ScheduleConflictException(String mensagem){
        super(mensagem);
    }
}
