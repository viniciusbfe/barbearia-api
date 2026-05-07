package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    @Query("SELECT COUNT(a) > 0 FROM Agendamento a WHERE a.barbeiro.id = :barbeiroId AND a.status = 'AGENDADO' AND a.dataHora < :fim AND a.dataHoraFim > :inicio")
    boolean existeConflito(Integer barbeiroId, LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT COUNT(a) > 0 FROM Agendamento a JOIN a.servicos s WHERE s.id = :servicoId")
    boolean existeAgendamentoComServico(Integer servicoId);
}
