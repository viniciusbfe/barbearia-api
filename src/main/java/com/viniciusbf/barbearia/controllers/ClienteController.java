package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.dtos.ClienteRequestDTO;
import com.viniciusbf.barbearia.dtos.ClienteUpdateDTO;
import com.viniciusbf.barbearia.entities.Cliente;
import com.viniciusbf.barbearia.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok(clienteService.create(clienteRequestDTO));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody ClienteUpdateDTO clienteUpdateDTO){
        return ResponseEntity.ok(clienteService.update(id, clienteUpdateDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
