package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
}
