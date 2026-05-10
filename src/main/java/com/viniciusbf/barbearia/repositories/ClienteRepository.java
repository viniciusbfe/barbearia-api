package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT COUNT(a) > 0 FROM Agendamento a WHERE a.cliente.id = :clienteId")
    boolean existeAgendamentoComCliente(Integer clienteId);
}
