package com.viniciusbf.barbearia;

import com.viniciusbf.barbearia.entities.*;
import com.viniciusbf.barbearia.entities.enums.StatusAgendamento;
import com.viniciusbf.barbearia.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final BarbeiroRepository barbeiroRepository;
    private final ClienteRepository clienteRepository;
    private final EspecialidadeRepository especialidadeRepository;
    private final ServicoRepository servicoRepository;
    private final AgendamentoRepository agendamentoRepository;

    public DataLoader(BarbeiroRepository barbeiroRepository, ClienteRepository clienteRepository, EspecialidadeRepository especialidadeRepository, ServicoRepository servicoRepository, AgendamentoRepository agendamentoRepository){
        this.barbeiroRepository = barbeiroRepository;
        this.clienteRepository = clienteRepository;
        this.especialidadeRepository = especialidadeRepository;
        this.servicoRepository = servicoRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Barbeiro b1 = new Barbeiro(null, "Barbeiro 1");
        Barbeiro b2 = new Barbeiro(null, "Barbeiro 2");
        Barbeiro b3 = new Barbeiro(null, "Barbeiro 3");
        barbeiroRepository.saveAll(Arrays.asList(b1, b2, b3));

        Cliente c1 = new Cliente(null, "Cliente 1", "11111111", "cliente1@gmail.com");
        Cliente c2 = new Cliente(null, "Cliente 2", "22222222", "cliente2@gmail.com");
        Cliente c3 = new Cliente(null, "Cliente 3", "33333333", "cliente3@gmail.com");
        clienteRepository.saveAll(Arrays.asList(c1, c2, c3));

        Especialidade e1 = new Especialidade(null, "Especialidade 1");
        Especialidade e2 = new Especialidade(null, "Especialidade 2");
        Especialidade e3 = new Especialidade(null, "Especialidade 3");
        Especialidade e4 = new Especialidade(null, "Especialidade 4");
        Especialidade e5 = new Especialidade(null, "Especialidade 5");
        especialidadeRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));

        Servico s1 = new Servico(null, "Servico 1", 30, 50);
        Servico s2 = new Servico(null, "Servico 2", 10, 100);
        Servico s3 = new Servico(null, "Servico 3", 50, 57);
        Servico s4 = new Servico(null, "Servico 4", 100, 10000);
        servicoRepository.saveAll(Arrays.asList(s1, s2, s3, s4));

        b1.getEspecialidades().add(e1);
        b1.getEspecialidades().add(e2);
        b2.getEspecialidades().add(e3);
        b3.getEspecialidades().add(e4);
        b3.getEspecialidades().add(e5);
        barbeiroRepository.saveAll(Arrays.asList(b1, b2, b3));

        LocalDateTime inicio = LocalDateTime.of(2025, 5, 10, 9, 0);
        LocalDateTime fim = inicio.plusMinutes(s1.getDuracao() + s3.getDuracao());
        Agendamento aa = new Agendamento(null, inicio, fim, StatusAgendamento.AGENDADO, c1, b1, (s1.getPreco()) + s3.getPreco());
        aa.getServicos().add(s1);
        aa.getServicos().add(s3);
        agendamentoRepository.save(aa);

    }

}
