package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.entities.Servico;
import com.viniciusbf.barbearia.repositories.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> getAll(){
        return servicoRepository.findAll();
    }

    public Servico getById(Integer id){
        return servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico " + id + " não encontrado."));
    }
}
