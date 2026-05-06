package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.entities.Cliente;
import com.viniciusbf.barbearia.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.getById(id));
    }
}
