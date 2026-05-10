package com.viniciusbf.barbearia.repositories;

import com.viniciusbf.barbearia.entities.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Barbeiro b JOIN b.especialidades e WHERE e.id = :especialidadeId")
    boolean existeBarbeiroComEspecialidade(Integer especialidadeId);
}
