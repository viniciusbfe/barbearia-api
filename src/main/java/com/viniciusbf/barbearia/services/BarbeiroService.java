package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.entities.Barbeiro;
import com.viniciusbf.barbearia.repositories.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository){
        this.barbeiroRepository = barbeiroRepository;
    }

    public List<Barbeiro> getAll(){
        return barbeiroRepository.findAll();
    }

    public Barbeiro getById(Integer id){
        return barbeiroRepository.findById(id).orElseThrow(() -> new RuntimeException("Barbeiro ID " + id + " não encontrado.."));
    }
}
