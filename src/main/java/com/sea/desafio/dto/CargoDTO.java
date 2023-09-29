package com.sea.desafio.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.sea.desafio.entidades.Cargo;
import com.sea.desafio.entidades.Setor;
import com.sea.desafio.entidades.Trabalhador;

public class CargoDTO {

	private Long id;
	private String nome;
	private Setor setor;
	private List<Trabalhador> trabalhadores;
	
	public CargoDTO() {}

	public CargoDTO(Cargo cargo) {
		BeanUtils.copyProperties(cargo, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<Trabalhador> getTrabalhadores() {
		return trabalhadores;
	}

	public void setTrabalhadores(List<Trabalhador> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}
}
