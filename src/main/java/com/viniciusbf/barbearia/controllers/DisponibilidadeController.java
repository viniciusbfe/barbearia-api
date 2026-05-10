package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.entities.Disponibilidade;
import com.viniciusbf.barbearia.services.DisponibilidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/disponibilidades")
public class DisponibilidadeController {

    private final DisponibilidadeService disponibilidadeService;

    public DisponibilidadeController(DisponibilidadeService disponibilidadeService){
        this.disponibilidadeService = disponibilidadeService;
    }

    @GetMapping(value = "/barbeiro/{id}")
    public ResponseEntity<List<LocalTime>> getDisponibilidadeByBarberId(@PathVariable Integer id, @RequestParam LocalDate data){
        return ResponseEntity.ok(disponibilidadeService.getSlotsDisponiveis(id, data));
    }
}
