package com.memory.colaboradores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memory.colaboradores.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>  {

}
