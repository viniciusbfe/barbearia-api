package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
