package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.entities.Especialidade;
import com.viniciusbf.barbearia.repositories.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeService(EspecialidadeRepository especialidadeRepository){
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<Especialidade> getAll(){
        return especialidadeRepository.findAll();
    }

    public Especialidade getById(Integer id){
        return especialidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade " + id + " não encontrada."));
    }
}
