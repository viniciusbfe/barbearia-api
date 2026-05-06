package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.entities.Servico;
import com.viniciusbf.barbearia.services.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService){
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getAll(){
        return ResponseEntity.ok(servicoService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> getById(@PathVariable Integer id){
        return ResponseEntity.ok(servicoService.getById(id));
    }
}
