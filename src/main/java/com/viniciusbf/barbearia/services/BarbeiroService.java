package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.BarbeiroRequestDTO;
import com.viniciusbf.barbearia.dtos.BarbeiroUpdateDTO;
import com.viniciusbf.barbearia.entities.Barbeiro;
import com.viniciusbf.barbearia.entities.Especialidade;
import com.viniciusbf.barbearia.exceptions.BarberInUseException;
import com.viniciusbf.barbearia.exceptions.ResourceNotFoundException;
import com.viniciusbf.barbearia.repositories.BarbeiroRepository;
import com.viniciusbf.barbearia.repositories.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;
    private final EspecialidadeRepository especialidadeRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository, EspecialidadeRepository especialidadeRepository){
        this.barbeiroRepository = barbeiroRepository;
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<Barbeiro> getAll(){
        return barbeiroRepository.findAll();
    }

    public Barbeiro getById(Integer id){
        return barbeiroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Barbeiro ID " + id + " não encontrado.."));
    }

    public Barbeiro create(BarbeiroRequestDTO barbeiroRequestDTO){
        Barbeiro barbeiro = new Barbeiro(null, barbeiroRequestDTO.getNome());

        for (Integer num : barbeiroRequestDTO.getEspecialidades()){
            Especialidade esp = especialidadeRepository.findById(num).orElseThrow(() -> new ResourceNotFoundException("Especialidade " + num + " não encontrada."));
            barbeiro.getEspecialidades().add(esp);
        }

        return barbeiroRepository.save(barbeiro);
    }

    public Barbeiro update(Integer id, BarbeiroUpdateDTO barbeiroUpdateDTO){
        Barbeiro barbeiro = barbeiroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Barbeiro id " + id + " não encontrado."));

        barbeiro.getEspecialidades().clear();

        for (Integer num : barbeiroUpdateDTO.getEspecialidades()){
            Especialidade esp = especialidadeRepository.findById(num).orElseThrow(() -> new ResourceNotFoundException("Especialidade " + num + " não encontrada."));
            barbeiro.getEspecialidades().add(esp);
        }

        return barbeiroRepository.save(barbeiro);
    }

    public void delete(Integer id){
        if (barbeiroRepository.existsById(id)){
            if (!barbeiroRepository.existeAgendamentoComBarbeiro(id)){
                barbeiroRepository.deleteById(id);
            } else {
                throw new BarberInUseException("O barbeiro " + id + " está agendado e não pode ser deletado.");
            }
        } else {
            throw new ResourceNotFoundException("Barbeiro " + id + " não encontrado.");
        }

    }

}
