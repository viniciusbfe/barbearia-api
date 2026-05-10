package com.viniciusbf.barbearia.repositories;


import com.viniciusbf.barbearia.entities.Disponibilidade;
import com.viniciusbf.barbearia.entities.enums.DiaSemana;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Integer> {

    List<Disponibilidade> findByBarbeiroId(Integer barbeiroId);
    Optional<Disponibilidade> findByBarbeiroIdAndDiaSemana(Integer barbeiroId, DiaSemana diaSemana);


}
