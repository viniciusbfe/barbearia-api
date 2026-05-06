package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.entities.Agendamento;
import com.viniciusbf.barbearia.services.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
