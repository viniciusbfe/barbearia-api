package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.entities.Cliente;
import com.viniciusbf.barbearia.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Cliente getById(Integer id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente " + id + " não encontrado."));
    }
}
