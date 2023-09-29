package com.sea.desafio.dto;

import com.sea.desafio.entidades.Cargo;

public class CargoMinDTO {

	private Long id;
	private String nome;
	private SetorMinDTO setor;
	
	public CargoMinDTO() {}

	public CargoMinDTO(Cargo cargo) {
		id = cargo.getId();
		nome = cargo.getNome();
		setor = new SetorMinDTO(cargo.getSetor());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public SetorMinDTO getSetor() {
		return setor;
	}
}
