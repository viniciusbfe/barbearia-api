package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Integer> {

    @Query("SELECT COUNT(a) > 0 FROM Agendamento a WHERE a.barbeiro.id = :barbeiroId")
    boolean existeAgendamentoComBarbeiro(Integer barbeiroId);

}
