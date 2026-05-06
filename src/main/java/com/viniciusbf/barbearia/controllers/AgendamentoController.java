package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.dtos.AgendamentoRequestDTO;
import com.viniciusbf.barbearia.entities.Agendamento;
import com.viniciusbf.barbearia.services.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    private AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService){
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> getAll(){
        return ResponseEntity.ok(agendamentoService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> getById(@PathVariable Integer id){
        return ResponseEntity.ok(agendamentoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody AgendamentoRequestDTO agendamentoRequestDTO){
        return ResponseEntity.ok(agendamentoService.create(agendamentoRequestDTO));
    }
}
