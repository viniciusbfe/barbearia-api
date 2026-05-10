package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.AgendamentoRequestDTO;
import com.viniciusbf.barbearia.dtos.AgendamentoUpdateDTO;
import com.viniciusbf.barbearia.entities.*;
import com.viniciusbf.barbearia.entities.enums.DiaSemana;
import com.viniciusbf.barbearia.entities.enums.StatusAgendamento;
import com.viniciusbf.barbearia.exceptions.OutsideWorkingHoursException;
import com.viniciusbf.barbearia.exceptions.ScheduleConflictException;
import com.viniciusbf.barbearia.exceptions.ResourceNotFoundException;
import com.viniciusbf.barbearia.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final DisponibilidadeRepository disponibilidadeRepository;


    public AgendamentoService(AgendamentoRepository agendamentoRepository, ServicoRepository servicoRepository, ClienteRepository clienteRepository, BarbeiroRepository barbeiroRepository, DisponibilidadeRepository disponibilidadeRepository){
        this.agendamentoRepository = agendamentoRepository;
        this.servicoRepository = servicoRepository;
        this.clienteRepository = clienteRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    public List<Agendamento> getAll(){
        return agendamentoRepository.findAll();
    }

    public Agendamento getById(Integer id){
        return agendamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agendamento " + id + " não encontrado."));
    }

    public Agendamento create(AgendamentoRequestDTO agendamentoRequestDTO) {

        int duracaoTotal = 0;
        double valorTotal = 0;
        Set<Servico> servicos = new HashSet<>();

        for (Integer servicoId : agendamentoRequestDTO.getServicoIds()){
            Servico servico = servicoRepository.findById(servicoId).orElseThrow(() -> new ResourceNotFoundException("Servico " + servicoId + " não encontrado."));
            duracaoTotal += servico.getDuracao();
            valorTotal += servico.getPreco();
            servicos.add(servico);
        }

        LocalDateTime dataHoraFim = agendamentoRequestDTO.getDataHora().plusMinutes(duracaoTotal);

        Cliente cliente = clienteRepository.findById(agendamentoRequestDTO.getClienteId()).orElseThrow(() -> new ResourceNotFoundException("Cliente " + agendamentoRequestDTO.getClienteId() + " não encontrado."));
        Barbeiro barbeiro = barbeiroRepository.findById(agendamentoRequestDTO.getBarbeiroId()).orElseThrow(() -> new ResourceNotFoundException("Barbeiro " + agendamentoRequestDTO.getBarbeiroId() + " não encontrado."));
        Agendamento agendamento = new Agendamento(null,agendamentoRequestDTO.getDataHora(), dataHoraFim, StatusAgendamento.AGUARDANDO, cliente, barbeiro, valorTotal);
        agendamento.getServicos().addAll(servicos);

        DiaSemana diaSemana = DiaSemana.fromDayOfWeek(agendamentoRequestDTO.getDataHora().getDayOfWeek());

        Disponibilidade disponibilidade = disponibilidadeRepository
                .findByBarbeiroIdAndDiaSemana(agendamentoRequestDTO.getBarbeiroId(), diaSemana)
                .orElseThrow(() -> new ResourceNotFoundException("Barbeiro não trabalha nesse dia."));

        if (agendamentoRequestDTO.getDataHora().toLocalTime().isBefore(disponibilidade.getHoraInicio()) ||
                dataHoraFim.toLocalTime().isAfter(disponibilidade.getHoraFim())) {
            throw new OutsideWorkingHoursException("Horário fora da janela de trabalho do barbeiro.");
        }

        if (agendamentoRepository.existeConflito(agendamentoRequestDTO.getBarbeiroId(), agendamentoRequestDTO.getDataHora(), dataHoraFim)){
           throw new ScheduleConflictException("Conlfito de horários na agenda do barbeiro, horário indisponível.");
       }

        agendamento.setStatus(StatusAgendamento.AGENDADO);
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento update(Integer id, AgendamentoUpdateDTO agendamentoUpdateDTO){
        Agendamento agendamento = getById(id);
        if (agendamentoUpdateDTO.getStatusAgendamento() != null){
            agendamento.setStatus(agendamentoUpdateDTO.getStatusAgendamento());
        }


        if (agendamentoUpdateDTO.getBarbeiroId() != null){
            Barbeiro barbeiro = barbeiroRepository.findById(agendamentoUpdateDTO.getBarbeiroId()).orElseThrow(() -> new ResourceNotFoundException("Barbeiro id " + agendamentoUpdateDTO.getBarbeiroId() + " não encontrado."));
            agendamento.setBarbeiro(barbeiro);
        }

        if (agendamentoUpdateDTO.getDataHora() != null){
            agendamento.setDataHora(agendamentoUpdateDTO.getDataHora());
        }

        if (!agendamentoUpdateDTO.getServicoIds().isEmpty()){
            agendamento.getServicos().clear();
            int duracao = 0;
            double valor = 0;
            for (Integer servicoId : agendamentoUpdateDTO.getServicoIds()){
                Servico servico = servicoRepository.findById(servicoId).orElseThrow(() -> new ResourceNotFoundException("Servico id " + servicoId + " não encontrado."));
                agendamento.getServicos().add(servico);
                duracao += servico.getDuracao();
                valor += servico.getPreco();
            }
            agendamento.setDataHoraFim(agendamento.getDataHora().plusMinutes(duracao));
            agendamento.setValorTotal(valor);
        }

        return agendamentoRepository.save(agendamento);
    }

    public void delete(Integer id){
        if (agendamentoRepository.existsById(id)){
            agendamentoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Servico id " + id + " não encontrado.");
        }
    }
}
