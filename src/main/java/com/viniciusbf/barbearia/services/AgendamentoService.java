package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.AgendamentoRequestDTO;
import com.viniciusbf.barbearia.entities.Agendamento;
import com.viniciusbf.barbearia.entities.Barbeiro;
import com.viniciusbf.barbearia.entities.Cliente;
import com.viniciusbf.barbearia.entities.Servico;
import com.viniciusbf.barbearia.entities.enums.StatusAgendamento;
import com.viniciusbf.barbearia.repositories.AgendamentoRepository;
import com.viniciusbf.barbearia.repositories.BarbeiroRepository;
import com.viniciusbf.barbearia.repositories.ClienteRepository;
import com.viniciusbf.barbearia.repositories.ServicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;
    private final BarbeiroRepository barbeiroRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, ServicoRepository servicoRepository, ClienteRepository clienteRepository, BarbeiroRepository barbeiroRepository){
        this.agendamentoRepository = agendamentoRepository;
        this.servicoRepository = servicoRepository;
        this.clienteRepository = clienteRepository;
        this.barbeiroRepository = barbeiroRepository;
    }

    public List<Agendamento> getAll(){
        return agendamentoRepository.findAll();
    }

    public Agendamento getById(Integer id){
        return agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento " + id + " não encontrado."));
    }

    public Agendamento create(AgendamentoRequestDTO agendamentoRequestDTO) {

        int duracaoTotal = 0;
        double valorTotal = 0;
        Set<Servico> servicos = new HashSet<>();

        for (Integer servicoId : agendamentoRequestDTO.getServicoIds()){
            Servico servico = servicoRepository.findById(servicoId).orElseThrow(() -> new RuntimeException(""));
            duracaoTotal += servico.getDuracao();
            valorTotal += servico.getPreco();
            servicos.add(servico);
        }

        LocalDateTime dataHoraFim = agendamentoRequestDTO.getDataHora().plusMinutes(duracaoTotal);

        Cliente cliente = clienteRepository.findById(agendamentoRequestDTO.getClienteId()).orElseThrow(() -> new RuntimeException(""));
        Barbeiro barbeiro = barbeiroRepository.findById(agendamentoRequestDTO.getBarbeiroId()).orElseThrow(() -> new RuntimeException(""));
        Agendamento agendamento = new Agendamento(null,agendamentoRequestDTO.getDataHora(), dataHoraFim, StatusAgendamento.AGUARDANDO, cliente, barbeiro, valorTotal);
        agendamento.getServicos().addAll(servicos);

       if (agendamentoRepository.existeConflito(agendamentoRequestDTO.getBarbeiroId(), agendamentoRequestDTO.getDataHora(), dataHoraFim)){
           throw new RuntimeException("Conlfito de horários na agenda do barbeiro, horário indisponível.");
       }

        agendamento.setStatus(StatusAgendamento.AGENDADO);
        return agendamentoRepository.save(agendamento);
    }
}
