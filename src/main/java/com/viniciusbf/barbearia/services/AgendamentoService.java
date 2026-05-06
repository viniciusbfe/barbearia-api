package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.entities.Agendamento;
import com.viniciusbf.barbearia.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> getAll(){
        return agendamentoRepository.findAll();
    }

    public Agendamento getById(Integer id){
        return agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento " + id + " não encontrado."));
    }
}
