package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.dtos.EspecialidadeRequestDTO;
import com.viniciusbf.barbearia.entities.Especialidade;
import com.viniciusbf.barbearia.services.EspecialidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Especialidade> create(@RequestBody EspecialidadeRequestDTO especialidadeRequestDTO){
        return ResponseEntity.ok(especialidadeService.create(especialidadeRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        especialidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
