package com.sea.desafio.dto;

import com.sea.desafio.entidades.Trabalhador;

public class TrabalhadorDTO {

	private Long id;
	private String cpf;
	private String nome;
	private CargoDTO cargo;
	
	public TrabalhadorDTO() {}

	public TrabalhadorDTO(Trabalhador trabalhador) {
		id = trabalhador.getId();
		cpf = trabalhador.getCpf();
		nome = trabalhador.getNome();
		cargo = new CargoDTO(trabalhador.getCargo());
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

	public CargoDTO getCargo() {
		return cargo;
	}

}
