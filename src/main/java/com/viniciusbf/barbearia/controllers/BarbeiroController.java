package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.entities.Barbeiro;
import com.viniciusbf.barbearia.services.BarbeiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
