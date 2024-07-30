package com.memory.colaboradores.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "colaboradores")
public class Colaborador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ColaboradorID;
	@CPF(message = "CPF inválido")
	@Size(max = 11, message = "CPF contém apenas 11 digitos")
	private String CPF;
	@NotNull
	@Size(min = 3, message = "O nome dever ter no mínimo 03 caracteres")
	private String Nome;
	@Temporal(TemporalType.DATE)
	private Date admissao;
	@ManyToOne	
	@JoinColumn(name = "cargoid")
	private Cargo Cargo;
	@OneToOne
	@JoinColumn(name="departamentoid", nullable = true)
	private Departamento Local;

	public Colaborador() {
		// TODO Auto-generated constructor stub
	}

	public Colaborador(Long colaboradorID, String cPF, String nome, Date dataAdmissao, Cargo cargo,
			Departamento departamento) {
		super();
		ColaboradorID = colaboradorID;
		CPF = cPF;
		Nome = nome;
		this.admissao = dataAdmissao;
		Cargo = cargo;
		Local = departamento;
	}

	public Long getColaboradorID() {
		return ColaboradorID;
	}

	public void setColaboradorID(Long colaboradorID) {
		ColaboradorID = colaboradorID;
	}

	public String getCPF() {
		return CPF.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}

	@PrePersist
	@PreUpdate
	public void removerFormacatao() {
		this.CPF.replaceAll("\\\\\\\\.|-|/", "");
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getAdmissao() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = admissao.toLocalDate();
		return localDate.format(formatter);
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public Cargo getCargo() {
		return Cargo;
	}

	public void setCargo(Cargo cargo) {
		Cargo = cargo;
	}

	public Departamento getDepartamento() {
		return Local;
	}

	public void setDepartamento(Departamento departamento) {
		Local = departamento;
	}

}
