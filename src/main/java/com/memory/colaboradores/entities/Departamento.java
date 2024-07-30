package com.memory.colaboradores.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long DepartamentoID;
	private String Descricao;
	@OneToOne
	@JoinColumn(name = "ColaboradorID")
	private Colaborador Gerente;
	@OneToMany(mappedBy = "Local")
	private List<Colaborador> Colaboradores = new ArrayList<Colaborador>();

	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public Departamento(Long departamentoID, String descricao, Colaborador gerente, List<Colaborador> colaboradores) {
		super();
		DepartamentoID = departamentoID;
		Descricao = descricao;
		Gerente = gerente;
		Colaboradores = colaboradores;
	}

	public long getDepartamentoID() {
		return DepartamentoID;
	}

	public void setDepartamentoID(Long departamentoID) {
		DepartamentoID = departamentoID;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Colaborador getGerente() {
		return Gerente;
	}

	public void setGerente(Colaborador gerente) {
		Gerente = gerente;
	}

}
