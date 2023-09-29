package com.sea.desafio.dto;

import com.sea.desafio.entidades.Cargo;

public class CargoDTO {

	private Long id;
	private String nome;
	private SetorDTO setor;
	
	public CargoDTO() {}

	public CargoDTO(Cargo cargo) {
		id = cargo.getId();
		nome = cargo.getNome();
		setor = new SetorDTO(cargo.getSetor());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public SetorDTO getSetor() {
		return setor;
	}
}
