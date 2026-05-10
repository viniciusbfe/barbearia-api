package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.EspecialidadeRequestDTO;
import com.viniciusbf.barbearia.entities.Especialidade;
import com.viniciusbf.barbearia.exceptions.SpecialtyInUseUsoException;
import com.viniciusbf.barbearia.exceptions.ResourceNotFoundException;
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
        return especialidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialidade " + id + " não encontrada."));
    }

    public Especialidade create(EspecialidadeRequestDTO especialidadeRequestDTO){
        Especialidade especialidade = new Especialidade(null, especialidadeRequestDTO.getNome());
        especialidadeRepository.save(especialidade);
        return especialidade;
    }

    public void delete(Integer id){
        if (especialidadeRepository.existsById(id)){
            if (!especialidadeRepository.existeBarbeiroComEspecialidade(id)){
                especialidadeRepository.deleteById(id);
            } else {
                throw new SpecialtyInUseUsoException("Especialidade " + id + " está atribuida a barbeiro e não pode ser excluida.");
            }
        } else {
            throw new ResourceNotFoundException("Especialidade " + id + " não encontrada.");
        }
    }
}
