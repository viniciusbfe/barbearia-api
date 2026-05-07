package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.ServicoUpdateDTO;
import com.viniciusbf.barbearia.entities.Servico;
import com.viniciusbf.barbearia.exceptions.ResourceNotFoundException;
import com.viniciusbf.barbearia.exceptions.ServicoEmUsoException;
import com.viniciusbf.barbearia.repositories.AgendamentoRepository;
import com.viniciusbf.barbearia.repositories.ServicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final AgendamentoRepository agendamentoRepository;

    public ServicoService(ServicoRepository servicoRepository, AgendamentoRepository agendamentoRepository){
        this.servicoRepository = servicoRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Servico> getAll(){
        return servicoRepository.findAll();
    }

    public Servico getById(Integer id){
        return servicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servico " + id + " não encontrado."));
    }

    public Servico update(Integer id, ServicoUpdateDTO servicoUpdateDTO){
        Servico servico = getById(id);
        if (servicoUpdateDTO.getDuracao() != null){
            servico.setDuracao(servicoUpdateDTO.getDuracao());
        }

        if (servicoUpdateDTO.getPreco() != null){
            servico.setPreco(servicoUpdateDTO.getPreco());
        }
        return servicoRepository.save(servico);
    }

    public void delete(Integer id){
        if (servicoRepository.existsById(id)){
            if (agendamentoRepository.existeAgendamentoComServico(id)){
                throw new ServicoEmUsoException("O serviço id " + id + " está atrelado a um agendamento e não pode ser excluído.");
            } else {
                servicoRepository.deleteById(id);
            }
        } else {
            throw new ResourceNotFoundException("Não existe o serviço id " + id);
        }
    }
}
