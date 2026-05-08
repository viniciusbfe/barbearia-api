package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.dtos.BarbeiroRequestDTO;
import com.viniciusbf.barbearia.dtos.BarbeiroUpdateDTO;
import com.viniciusbf.barbearia.entities.Barbeiro;
import com.viniciusbf.barbearia.services.BarbeiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/barbeiros")
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService){
        this.barbeiroService = barbeiroService;
    }

    @GetMapping
    public ResponseEntity<List<Barbeiro>> getAll(){
        return ResponseEntity.ok(barbeiroService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Barbeiro> getById(@PathVariable Integer id){
        return ResponseEntity.ok(barbeiroService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Barbeiro> create(@RequestBody BarbeiroRequestDTO barbeiroRequestDTO){
        return ResponseEntity.ok(barbeiroService.create(barbeiroRequestDTO));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Barbeiro> update(@PathVariable Integer id, @RequestBody BarbeiroUpdateDTO barbeiroUpdateDTO){
        return ResponseEntity.ok(barbeiroService.update(id, barbeiroUpdateDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        barbeiroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
