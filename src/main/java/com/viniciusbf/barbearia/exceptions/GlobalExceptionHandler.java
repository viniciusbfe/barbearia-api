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

    @ExceptionHandler(ScheduleConflictException.class)
    public ResponseEntity<ApiError> conflitoHorario(ScheduleConflictException e){
        ApiError error = new ApiError(409, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(409).body(error);

    }

    @ExceptionHandler(ServiceInUseException.class)
    public ResponseEntity<ApiError> servicoEmUso(ServiceInUseException e){
        ApiError error = new ApiError(409, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(BarberInUseException.class)
    public ResponseEntity<ApiError> barbeiroEmUso(BarberInUseException e){
        ApiError error = new ApiError(409, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(ClientInUseException.class)
    public ResponseEntity<ApiError> clienteEmUso(ClientInUseException e){
        ApiError error = new ApiError(409, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(SpecialtyInUseUsoException.class)
    public ResponseEntity<ApiError> clienteEmUso(SpecialtyInUseUsoException e){
        ApiError error = new ApiError(409, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(OutsideWorkingHoursException.class)
    public ResponseEntity<ApiError> horarioForaDeExpediente(OutsideWorkingHoursException e){
        ApiError error = new ApiError(400, e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(400).body(error);
    }

}
