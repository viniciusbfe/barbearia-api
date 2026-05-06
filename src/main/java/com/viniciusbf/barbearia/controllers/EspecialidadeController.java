package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.entities.Especialidade;
import com.viniciusbf.barbearia.services.EspecialidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService){
        this.especialidadeService = especialidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Especialidade>> getAll(){
        return ResponseEntity.ok(especialidadeService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Especialidade> getById(@PathVariable Integer id){
        return ResponseEntity.ok(especialidadeService.getById(id));
    }
}
