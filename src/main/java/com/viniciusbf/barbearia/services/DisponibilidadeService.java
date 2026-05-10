package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.DisponibilidadeRequestDTO;
import com.viniciusbf.barbearia.entities.Barbeiro;
import com.viniciusbf.barbearia.entities.Disponibilidade;
import com.viniciusbf.barbearia.entities.enums.DiaSemana;
import com.viniciusbf.barbearia.exceptions.ResourceNotFoundException;
import com.viniciusbf.barbearia.repositories.AgendamentoRepository;
import com.viniciusbf.barbearia.repositories.BarbeiroRepository;
import com.viniciusbf.barbearia.repositories.DisponibilidadeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DisponibilidadeService {

    private final DisponibilidadeRepository disponibilidadeRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final AgendamentoRepository agendamentoRepository;

    public DisponibilidadeService(DisponibilidadeRepository disponibilidadeRepository, BarbeiroRepository barbeiroRepository, AgendamentoRepository agendamentoRepository){
        this.disponibilidadeRepository = disponibilidadeRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Disponibilidade> getAllByBarberiroId(Integer id){
        return disponibilidadeRepository.findByBarbeiroId(id);
    }

    public Disponibilidade getById(Integer id){
        return disponibilidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Barbeiro " + id + " não encontrado."));
    }

    public Disponibilidade create(DisponibilidadeRequestDTO disponibilidadeRequestDTO){
        Barbeiro barbeiro = barbeiroRepository.findById(disponibilidadeRequestDTO.getBarbeiroId()).orElseThrow(() -> new ResourceNotFoundException("Barbeiro " + disponibilidadeRequestDTO.getBarbeiroId() + " não encontrado."));
        Disponibilidade disponibilidade = new Disponibilidade(null, barbeiro, disponibilidadeRequestDTO.getDiaSemana(), disponibilidadeRequestDTO.getHoraInicio(), disponibilidadeRequestDTO.getHoraFim());
        return disponibilidadeRepository.save(disponibilidade);
    }

    public List<LocalTime> getSlotsDisponiveis(Integer barberId, LocalDate data){
        DiaSemana diaSemana = DiaSemana.fromDayOfWeek(data.getDayOfWeek());
        Disponibilidade disponibilidade = disponibilidadeRepository.findByBarbeiroIdAndDiaSemana(barberId, diaSemana).orElseThrow(() -> new ResourceNotFoundException("Barbeiro não trabalha esse dia."));

        List<LocalTime> slots = new ArrayList<>();
        LocalTime slot = disponibilidade.getHoraInicio();

        while (slot.plusMinutes(30).compareTo(disponibilidade.getHoraFim()) <= 0){
            slots.add(slot);
            slot = slot.plusMinutes(30);
        }

        slots.removeIf(s -> {
            LocalDateTime inicio = LocalDateTime.of(data, s);
            LocalDateTime fim = inicio.plusMinutes(30);
            return agendamentoRepository.existeConflito(barberId, inicio, fim);
        });

        return slots;
    }
}
