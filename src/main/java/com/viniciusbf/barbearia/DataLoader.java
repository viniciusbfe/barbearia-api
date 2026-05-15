package com.viniciusbf.barbearia;

import com.viniciusbf.barbearia.entities.*;
import com.viniciusbf.barbearia.entities.enums.DiaSemana;
import com.viniciusbf.barbearia.entities.enums.StatusAgendamento;
import com.viniciusbf.barbearia.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final BarbeiroRepository barbeiroRepository;
    private final ClienteRepository clienteRepository;
    private final EspecialidadeRepository especialidadeRepository;
    private final ServicoRepository servicoRepository;
    private final AgendamentoRepository agendamentoRepository;
    private final DisponibilidadeRepository disponibilidadeRepository;

    public DataLoader(BarbeiroRepository barbeiroRepository, ClienteRepository clienteRepository, EspecialidadeRepository especialidadeRepository, ServicoRepository servicoRepository, AgendamentoRepository agendamentoRepository, DisponibilidadeRepository disponibilidadeRepository){
        this.barbeiroRepository = barbeiroRepository;
        this.clienteRepository = clienteRepository;
        this.especialidadeRepository = especialidadeRepository;
        this.servicoRepository = servicoRepository;
        this.agendamentoRepository = agendamentoRepository;
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Barbeiro b1 = new Barbeiro(null, "Barbeiro 1");
        Barbeiro b2 = new Barbeiro(null, "Barbeiro 2");
        Barbeiro b3 = new Barbeiro(null, "Barbeiro 3");
        barbeiroRepository.saveAll(Arrays.asList(b1, b2, b3));

        Disponibilidade d1 = new Disponibilidade(null, b1, DiaSemana.SEGUNDA_FEIRA, LocalTime.of(9, 0), LocalTime.of(21, 0));
        Disponibilidade d2 = new Disponibilidade(null, b1, DiaSemana.TERCA_FEIRA, LocalTime.of(9, 0), LocalTime.of(21, 0));
        Disponibilidade d3 = new Disponibilidade(null, b3, DiaSemana.QUARTA_FEIRA, LocalTime.of(8, 0), LocalTime.of(18, 0));
        disponibilidadeRepository.saveAll(Arrays.asList(d1, d2, d3));

    }

}
