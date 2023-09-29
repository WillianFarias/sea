package com.sea.desafio.entidades;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;

	@OneToMany(mappedBy = "cargo")
	private List<Trabalhador> trabalhadores;

	public Cargo() {}

	public Cargo(String nome, Setor setor, List<Trabalhador> trabalhadores) {
		this.nome = nome;
		this.setor = setor;
		this.trabalhadores = trabalhadores;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(id, other.id);
	}
}
