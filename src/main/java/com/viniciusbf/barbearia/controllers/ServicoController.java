package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.dtos.ServicoRequestDTO;
import com.viniciusbf.barbearia.dtos.ServicoUpdateDTO;
import com.viniciusbf.barbearia.entities.Servico;
import com.viniciusbf.barbearia.services.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody ServicoRequestDTO servicoRequestDTO){
        return ResponseEntity.ok(servicoService.create(servicoRequestDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Servico> update(@PathVariable Integer id, @RequestBody ServicoUpdateDTO servicoUpdateDTO){
        return ResponseEntity.ok(servicoService.update(id, servicoUpdateDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
