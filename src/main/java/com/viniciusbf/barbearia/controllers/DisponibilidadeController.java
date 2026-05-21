package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.dtos.DisponibilidadeRequestDTO;
import com.viniciusbf.barbearia.entities.Disponibilidade;
import com.viniciusbf.barbearia.entities.enums.DiaSemana;
import com.viniciusbf.barbearia.services.DisponibilidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/disponibilidades")
public class DisponibilidadeController {

    private final DisponibilidadeService disponibilidadeService;

    public DisponibilidadeController(DisponibilidadeService disponibilidadeService){
        this.disponibilidadeService = disponibilidadeService;
    }

    @PostMapping
    public ResponseEntity<Disponibilidade> create(@RequestBody DisponibilidadeRequestDTO disponibilidadeRequestDTO){
        return ResponseEntity.ok(disponibilidadeService.create(disponibilidadeRequestDTO));
    }

    @GetMapping(value = "/barbeiro/{id}")
    public ResponseEntity<List<LocalTime>> getDisponibilidadeByBarberId(
            @PathVariable Integer id,
            @RequestParam LocalDate data,
            @RequestParam(required = false) List<Integer> servicoIds) {
        return ResponseEntity.ok(disponibilidadeService.getSlotsDisponiveis(id, data, servicoIds));
    }

    @GetMapping("/barbeiro/{id}/dias")
    public ResponseEntity<List<DiaSemana>> getDiasTrabalhados(@PathVariable Integer id) {
        return ResponseEntity.ok(disponibilidadeService.getDiasTrabalhadosByBarbeiroId(id));
    }
}