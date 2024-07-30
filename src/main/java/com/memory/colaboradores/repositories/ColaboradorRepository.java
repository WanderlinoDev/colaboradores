package com.memory.colaboradores.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memory.colaboradores.entities.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	List<Colaborador> findByAdmissaoBetween(Date dataInicio, Date dataFim);
}
