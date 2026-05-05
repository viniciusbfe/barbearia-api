package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
