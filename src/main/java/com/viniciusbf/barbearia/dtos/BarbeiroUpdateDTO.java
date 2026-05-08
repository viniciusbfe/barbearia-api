package com.viniciusbf.barbearia.dtos;

import java.util.HashSet;
import java.util.Set;

public class BarbeiroUpdateDTO {

    private Integer id;
    private Set<Integer> especialidades = new HashSet<>();

    public BarbeiroUpdateDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Integer> getEspecialidades() {
        return especialidades;
    }
}
