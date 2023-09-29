package com.sea.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sea.desafio.entidades.Trabalhador;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long>{

}