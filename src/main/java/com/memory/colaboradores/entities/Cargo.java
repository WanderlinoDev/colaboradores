package com.memory.colaboradores.entities;

import java.text.DecimalFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cargos")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CargoID;
	private String Descricao;
	private Double Remuneracao;

	public Cargo() {
		// TODO Auto-generated constructor stub
	}

	public Cargo(long cargoID, String descricao, Double remuneracao) {
		super();
		CargoID = cargoID;
		Descricao = descricao;
		Remuneracao = remuneracao;
	}

	public long getCargoID() {
		return CargoID;
	}

	public void setCargoID(long cargoID) {
		CargoID = cargoID;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getRemuneracao() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(Remuneracao);
	}

	public void setRemuneracao(Double remuneracao) {
		Remuneracao = remuneracao;
	}

}
