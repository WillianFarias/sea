package com.sea.desafio.dto;

import com.sea.desafio.entidades.Trabalhador;

public class TrabalhadorDTO {

	private Long id;
	private String cpf;
	private String nome;
	private CargoMinDTO cargo;
	
	public TrabalhadorDTO() {}

	public TrabalhadorDTO(Trabalhador trabalhador) {
		id = trabalhador.getId();
		cpf = trabalhador.getCpf();
		nome = trabalhador.getNome();
		cargo = new CargoMinDTO(trabalhador.getCargo());
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public CargoMinDTO getCargo() {
		return cargo;
	}

}
