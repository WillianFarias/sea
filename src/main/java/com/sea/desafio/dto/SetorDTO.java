package com.sea.desafio.dto;

import com.sea.desafio.entidades.Setor;

public class SetorDTO {

	private Long id;
	private String nome;
	
	public SetorDTO () {}

	public SetorDTO(Setor setor) {
		id = setor.getId();
		nome = setor.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
