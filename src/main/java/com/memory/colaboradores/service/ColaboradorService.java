package com.memory.colaboradores.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memory.colaboradores.entities.Colaborador;
import com.memory.colaboradores.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public List<Colaborador> listarColaboradoresPorAno(String ano) {
		LocalDate dataInicio = LocalDate.parse(ano + "-01-01");
		LocalDate dataFim = LocalDate.parse(ano + "-12-31");
		Date dataInicioDate = java.sql.Date.valueOf(dataInicio);
		Date dataFimDate = java.sql.Date.valueOf(dataFim);
		return repository.findByAdmissaoBetween(dataInicioDate, dataFimDate);
	}
}
