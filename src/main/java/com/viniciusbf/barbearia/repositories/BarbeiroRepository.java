package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Integer> {
}
