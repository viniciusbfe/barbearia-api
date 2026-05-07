package com.viniciusbf.barbearia.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException e) {
        ApiError error = new ApiError(404, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(ConflitoHorarioExcpetion.class)
    public ResponseEntity<ApiError> conflitoHorario(ConflitoHorarioExcpetion e){
        ApiError error = new ApiError(409, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(409).body(error);

    }

    @ExceptionHandler(ServicoEmUsoException.class)
    public ResponseEntity<ApiError> servicoEmUso(ServicoEmUsoException e){
        ApiError error = new ApiError(409, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(409).body(error);
    }
}
