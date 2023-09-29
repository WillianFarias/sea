package com.sea.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sea.desafio.entidades.Setor;

public interface SetorRepository  extends JpaRepository<Setor, Long> {

	Setor findByNome(String nome);
}
